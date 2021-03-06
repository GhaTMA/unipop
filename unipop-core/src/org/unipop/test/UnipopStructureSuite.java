package org.unipop.test;

import org.apache.tinkerpop.gremlin.AbstractGremlinSuite;
import org.apache.tinkerpop.gremlin.algorithm.generator.CommunityGeneratorTest;
import org.apache.tinkerpop.gremlin.algorithm.generator.DistributionGeneratorTest;
import org.apache.tinkerpop.gremlin.process.traversal.TraversalEngine;
import org.apache.tinkerpop.gremlin.structure.*;
import org.apache.tinkerpop.gremlin.structure.io.*;
import org.apache.tinkerpop.gremlin.structure.util.detached.*;
import org.apache.tinkerpop.gremlin.structure.util.reference.*;
import org.apache.tinkerpop.gremlin.structure.util.star.StarGraphTest;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

public class UnipopStructureSuite extends AbstractGremlinSuite {

    public UnipopStructureSuite(final Class<?> klass, final RunnerBuilder builder) throws InitializationError {
        super(klass, builder, allTests, null, false, TraversalEngine.Type.STANDARD);
    }

    private static final Class<?>[] allTests = new Class<?>[]{
            GraphConstructionTest.class,
            VertexTest.class,
            EdgeTest.class,
            PropertyTest.class,
            VertexPropertyTest.class,
            GraphTest.class,
            FeatureSupportTest.class,

            DetachedGraphTest.class,
            DetachedEdgeTest.class,
            DetachedVertexPropertyTest.class,
            DetachedPropertyTest.class,
            DetachedVertexTest.class,

            ReferenceGraphTest.class,
            ReferenceEdgeTest.class,
            ReferenceVertexPropertyTest.class,
            ReferenceVertexTest.class,

            SerializationTest.class,
            IoCustomTest.class,
            IoEdgeTest.class,
            IoGraphTest.class,
            IoVertexTest.class,
            IoPropertyTest.class,
            IoTest.class,

            CommunityGeneratorTest.class,
            DistributionGeneratorTest.class,

            //Ignored tests
            StarGraphTest.class,
            TransactionTest.class,
            VariablesTest.class,
    };
}
