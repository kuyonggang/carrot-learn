package com.carrot.learn.zookeeper;

import org.apache.zookeeper.WatchedEvent;


public interface ZkListener {
	
	public void dataEvent(WatchedEvent event);
}

