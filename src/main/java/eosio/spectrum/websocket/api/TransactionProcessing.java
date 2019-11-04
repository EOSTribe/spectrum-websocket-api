package eosio.spectrum.websocket.api;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class TransactionProcessing {
    private JSONObject transactionMessage;
    private ArrayList<JSONObject> newAccountActions;
    private ArrayList<JSONObject> transferActions;



    private static final transient Logger logger = LoggerFactory.getLogger(TransactionProcessing.class);

    public TransactionProcessing(JSONObject transactionMessage){
        this.transactionMessage = transactionMessage;
    }

    public ArrayList<JSONObject> getActions(){
        ArrayList<JSONObject> actions = new ArrayList<>();
        newAccountActions = new ArrayList<>();
        transferActions = new ArrayList<>();
        JSONObject jsonAction = null;
        String actionData;
        for (Object action:this.transactionMessage.getJSONObject("trace").getJSONArray("action_traces")){
            if (action instanceof JSONObject){
                jsonAction = (JSONObject)action;
                jsonAction.put("block_num", this.transactionMessage.getInt("block_num"));
                jsonAction.put("block_timestamp",this.transactionMessage.getString("block_timestamp"));
                jsonAction.put("trx",this.transactionMessage.getJSONObject("trace").getString("id"));

                /**
                 * converting act.data field to string
                 */
                actionData = jsonAction.getJSONObject("act").get("data").toString();
                jsonAction.getJSONObject("act").put("data",actionData);

            }else {
                logger.warn("Can't decode action: "+action.toString());
            }
            if (jsonAction.getJSONObject("act").getString("name").equals("transfer")){
                this.transferActions.add(jsonAction);
            }
            if (jsonAction.getJSONObject("act").getString("name").equals("newaccount")){
                this.newAccountActions.add(jsonAction);
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
        transaction.getJSONObject("trace").remove("action_traces");
        return transaction;
    }

    public ArrayList<JSONObject> getNewAccountActions(){

        return this.newAccountActions;
    }

    public ArrayList<JSONObject> getTransferActions(){
        return this.transferActions;
    }

}