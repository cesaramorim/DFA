package br.com.tclf.afd.model;

/**
 * Created with IntelliJ IDEA.
 * User: KESSILER
 * Date: 09/11/13
 * Time: 22:24
 * To change this template use File | Settings | File Templates.
 */
public class State {
    private String stateName;
    private Boolean stateEnd;
    private Boolean stateBegin;

    State(String name) {
        this.stateName = name;
    }

    public String getName() {
        return stateName;
    }

    public Boolean isStateEnd() {
        return (stateEnd == Boolean.TRUE);
    }

    public Boolean isStateBegin() {
        return (stateBegin == Boolean.TRUE);
    }

    public void setStateEnd(Boolean end) {
        this.stateEnd = end;
    }

    public void setStateBegin(Boolean begin) {
        this.stateBegin = begin;
    }
}
