package org.unipop.jdbc.schemas;

import org.apache.tinkerpop.gremlin.structure.Direction;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.json.JSONException;
import org.json.JSONObject;
import org.unipop.jdbc.schemas.jdbc.JdbcVertexSchema;
import org.unipop.query.predicates.PredicateQuery;
import org.unipop.schema.element.EdgeSchema;
import org.unipop.schema.element.ElementSchema;
import org.unipop.structure.UniGraph;
import org.unipop.structure.UniVertex;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.unipop.util.ConversionUtils.getList;

/**
 * @author Gur Ronen
 * @since 6/12/2016
 */
public class RowVertexSchema extends AbstractRowSchema<Vertex> implements JdbcVertexSchema {
    protected Set<ElementSchema> edgeSchemas = new HashSet<>();


    public RowVertexSchema(JSONObject configuration, UniGraph graph) {
        super(configuration, graph);


        for (JSONObject edgeJson : getList(json, "edges")) {
            EdgeSchema docEdgeSchema = getEdgeSchema(edgeJson);
            edgeSchemas.add(docEdgeSchema);
        }
    }

    @Override
    public List<Vertex> parseResults(String result, PredicateQuery query) {
        return null;
    }

    @Override
    public Vertex createElement(Map<String, Object> fields) {
        Map<String, Object> properties = getProperties(fields);
        if(properties == null) return null;
        return new UniVertex(properties, graph);
    }


    private EdgeSchema getEdgeSchema(JSONObject edgeJson) throws JSONException {
        Direction direction = Direction.valueOf(edgeJson.optString("direction"));

        return new InnerRowEdgeSchema(this, direction, edgeJson, graph);
    }
}
