package com.cebj.flinknew;

import org.apache.flink.api.common.state.KeyedStateStore;
import org.apache.flink.api.common.state.OperatorStateStore;
import org.apache.flink.runtime.state.FunctionInitializationContext;
import org.apache.flink.runtime.state.FunctionSnapshotContext;
import org.apache.flink.streaming.api.checkpoint.CheckpointedFunction;

public class MyCheckpointedFunction implements CheckpointedFunction {
	@Override
	public void snapshotState(FunctionSnapshotContext context) throws Exception {
		context.getCheckpointId();
		context.getCheckpointTimestamp();
	}

	@Override
	public void initializeState(FunctionInitializationContext context) throws Exception {
		KeyedStateStore keyedStateStore = context.getKeyedStateStore();
		OperatorStateStore operatorStateStore = context.getOperatorStateStore();

//		keyedStateStore.getAggregatingState();
//		keyedStateStore.getListState();
//		keyedStateStore.getMapState();
//		keyedStateStore.getReducingState();
//		keyedStateStore.getState();
//
//		operatorStateStore.getBroadcastState();
//		operatorStateStore.getListState();
//		operatorStateStore.getUnionListState();
	}
}
