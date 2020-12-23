package com.natsumes.work;

import com.natsumes.tree.SizeBalancedTree;

/**
 * @author hetengjiao
 */
public class SizeBalanceFinder extends AbstractTopFinder{

    public SizeBalanceFinder() {
        this.tree = new SizeBalancedTree<>();
    }
}
