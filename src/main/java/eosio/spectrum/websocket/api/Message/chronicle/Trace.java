package eosio.spectrum.websocket.api.Message.chronicle;

import java.util.List;

public class Trace {
    private Boolean scheduled;
    private Account_ram_delta account_ram_delta;
    private int net_usage;
    private List<ActionTraces> action_traces;
    private List<Failed_dtrx_trace> failed_dtrx_trace;
    private int elapsed;
    private int net_usage_words;
    private String except;
    private String error_code;
    private String id;
    private int cpu_usage_us;
    private Partial partial;
    private String status;

    public Boolean getScheduled() {
        return scheduled;
    }

    public void setScheduled(Boolean scheduled) {
        this.scheduled = scheduled;
    }

    public Account_ram_delta getAccount_ram_delta() {
        return account_ram_delta;
    }

    public void setAccount_ram_delta(Account_ram_delta account_ram_delta) {
        this.account_ram_delta = account_ram_delta;
    }

    public int getNet_usage() {
        return net_usage;
    }

    public void setNet_usage(int net_usage) {
        this.net_usage = net_usage;
    }

    public List<ActionTraces> getAction_traces() {
        return action_traces;
    }

    public void setAction_traces(List<ActionTraces> action_traces) {
        this.action_traces = action_traces;
    }

    public List<Failed_dtrx_trace> getFailed_dtrx_trace() {
        return failed_dtrx_trace;
    }

    public void setFailed_dtrx_trace(List<Failed_dtrx_trace> failed_dtrx_trace) {
        this.failed_dtrx_trace = failed_dtrx_trace;
    }

    public int getElapsed() {
        return elapsed;
    }

    public void setElapsed(int elapsed) {
        this.elapsed = elapsed;
    }

    public int getNet_usage_words() {
        return net_usage_words;
    }

    public void setNet_usage_words(int net_usage_words) {
        this.net_usage_words = net_usage_words;
    }

    public String getExcept() {
        return except;
    }

    public void setExcept(String except) {
        this.except = except;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCpu_usage_us() {
        return cpu_usage_us;
    }

    public void setCpu_usage_us(int cpu_usage_us) {
        this.cpu_usage_us = cpu_usage_us;
    }

    public Partial getPartial() {
        return partial;
    }

    public void setPartial(Partial partial) {
        this.partial = partial;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
