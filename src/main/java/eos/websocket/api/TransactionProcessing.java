package eos.websocket.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;

public class TransactionProcessing {
    private JSONObject transactionMessage;
    private HashSet actionsSet = new HashSet();

    private static final transient Logger logger = LoggerFactory.getLogger(TransactionProcessing.class);

    public TransactionProcessing(JSONObject transactionMessage){
        this.transactionMessage = transactionMessage;
        this.actionsSet.add("eostribeprod");
    }



    public ArrayList<JSONObject> getActions(){
        ArrayList<JSONObject> actions = new ArrayList<>();
        JSONObject jsonAction = null;
        String actionData;
        for (Object action:this.transactionMessage.getJSONObject("trace").getJSONArray("action_traces")){
            if (action instanceof JSONObject){
                jsonAction = (JSONObject)action;
                jsonAction.put("block_num", this.transactionMessage.get("block_num"));
                jsonAction.put("block_timestamp",this.transactionMessage.get("block_timestamp"));
                jsonAction.put("trx",this.transactionMessage.getJSONObject("trace").get("id"));

                /**
                 * converting act.data field to string
                 */
                actionData = jsonAction.getJSONObject("act").get("data").toString();
                jsonAction.getJSONObject("act").put("data",actionData);

            }else {
                logger.warn("Can't decode action: "+action.toString());
            }
         actions.add(jsonAction);
        }
        return actions;
    }

    public JSONObject getTransaction(){
        String failedDtrxTrace;
        JSONObject transaction = this.transactionMessage;
        /**
         * Converting field failed_dtrx_trace to String
         */
        failedDtrxTrace = this.transactionMessage.
                getJSONObject("trace").
                get("failed_dtrx_trace").toString();
        transaction.getJSONObject("trace").put("failed_dtrx_trace",failedDtrxTrace);
        /**
         * removing filed actions from transaction
         */
        transaction.getJSONObject("trace").remove("actions");
        return transaction;
    }


}
