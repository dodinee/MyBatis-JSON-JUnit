package handler;

import java.util.concurrent.LinkedBlockingDeque;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

public class BlockingDequeResultHandler<T> implements ResultHandler<T> {
	
    private LinkedBlockingDeque<T> results = new LinkedBlockingDeque<>();

    
	@Override
	public void handleResult(ResultContext<? extends T> resultContext) {
		
		results.add(resultContext.getResultObject());
	}// handleResult
	
	public LinkedBlockingDeque<T> getResults() {
		
		return results;
	}// getResults
	
}//end class
