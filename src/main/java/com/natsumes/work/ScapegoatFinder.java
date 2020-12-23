package com.natsumes.work;

import com.natsumes.tree.ScapegoatTree;

/**
 * @author hetengjiao
 */
public class ScapegoatFinder extends AbstractTopFinder {

    public ScapegoatFinder() {
        this.tree = new ScapegoatTree<>();
    }
}
