package com.example.bank.Controllers.Graph;

import java.util.List;

public class GraphResponseBody {
// This class has no annotations. But since it's fields are String based, they can be
    // accessed on the client side, using javascript object notation (JSON)
    private String msg;
    private List<Vertex> result;
    private List<Edge> edges;

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public String getMsg() { // this will respond to a Object.msg call on the client-side.
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Vertex> getVertices() {
        return result;
    }

    public void setVertices(List<Vertex> result) {
        this.result = result;
    }
}
