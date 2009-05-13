package com.baosight;

public class SequenceFinderFactory {
	
	public static SequenceFind getSequenceFinder() {
		//TODO:具体的SequenceFind抽象产品实例类型改为从配置文件得到
		return new SequenceFindImpl();
	}

}
