package com.natsumes.redis;

/**
 * 布隆过滤器
 * 去重，判断某个元素是否存在
 *
 * @author hetengjiao
 */
public class BloomFilter {

    private static final int PRIME = 10000;

    private Bitmap bits = new Bitmap();


    public void add(String key) {
        for (BloomHash bloomHash : BloomHash.values()) {
            int hash = bloomHash.hash(key, PRIME);
            bits.set(hash);
        }
    }

    /**
     * not exists is right, exists may error
     * @param key key
     * @return boolean
     */
    public boolean contain(String key) {
        for (BloomHash bloomHash : BloomHash.values()) {
            int hash = bloomHash.hash(key, PRIME);
            if (!bits.get(hash)) {
                return false;
            }
        }
        return true;
    }

    private enum BloomHash {
        /**
         *
         */
        DEFAULT_HASH {
            @Override
            public IBloomHash getBloomHash() {
                return IBloomHash.defaultHash();
            }
        },

        ADDITIVE_HASH {
            @Override
            public IBloomHash getBloomHash() {
                return IBloomHash.additiveHash();
            }
        },

        ROTATING_HASH {
            @Override
            public IBloomHash getBloomHash() {
                return IBloomHash.rotatingHash();
            }
        },

        BERNSTEIN_HASH {
            @Override
            public IBloomHash getBloomHash() {
                return IBloomHash.bernsteinHash();
            }
        },

        OPTIMIZE_FNV_HASH {
            @Override
            public IBloomHash getBloomHash() {
                return IBloomHash.optimizeFnvHash();
            }
        },

        RS_HASH {
            @Override
            public IBloomHash getBloomHash() {
                return IBloomHash.rsHash();
            }
        },

        ;

        BloomHash() {

        }

        protected abstract IBloomHash getBloomHash();

        public int hash(String key, int prime) {
            return Math.abs(getBloomHash().hash(key, prime));
        }
    }

    private interface IBloomHash {
        /**
         * generate hash
         * @param key key
         * @param prime p
         * @return hash code
         */
        int hash(String key, int prime);

        /**
         * defaultHash
         * @return hash code
         */
        static IBloomHash defaultHash() {
            return (key, prime) -> key.hashCode() % prime;
        }

        /**
         * additiveHash
         * @return hash code
         */
        static IBloomHash additiveHash() {
            return (key, prime) -> {
                int hash, i;
                for (hash = key.length(), i = 0; i < key.length(); i++) {
                    hash += key.charAt(i);
                }
                return hash % prime;
            };
        }

        /**
         * additiveHash
         * @return hash code
         */
        static IBloomHash rotatingHash() {
            return (key, prime) -> {
                int hash, i;
                for (hash = key.length(), i = 0; i < key.length(); i++) {
                    hash = (hash << 4) ^ (hash >> 28) ^ key.charAt(i);
                }
                return hash % prime;
            };
        }

        /**
         * additiveHash
         * @return hash code
         */
        static IBloomHash bernsteinHash() {
            return (key, prime) -> {
                int hash = 0;
                for (int i = 0; i < key.length(); i++) {
                    hash = 33 * hash + key.charAt(i);
                }
                return hash % prime;
            };
        }

        /**
         * additiveHash
         * @return hash code
         */
        static IBloomHash optimizeFnvHash() {
            return (key, prime) -> {
                final int p = 16777619;
                int hash = (int) 2166136261L;
                for(int i = 0; i < key.length(); i++) {
                    hash = (hash ^ key.charAt(i)) * p;
                }
                hash += hash << 13;
                hash ^= hash >> 7;
                hash += hash << 3;
                hash ^= hash >> 17;
                hash += hash << 5;
                return hash % prime;
            };
        }

        /**
         * additiveHash
         * @return hash code
         */
        static IBloomHash rsHash() {
            return (key, prime) -> {
                int b    = 378551;
                int a    = 63689;
                int hash = 0;

                for(int i = 0; i < key.length(); i++)
                {
                    hash = hash * a + key.charAt(i);
                    a = a * b;
                }
                return (hash & 0x7FFFFFFF) % prime;
            };
        }
    }

}
