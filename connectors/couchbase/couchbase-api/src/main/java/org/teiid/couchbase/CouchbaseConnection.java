/*
 * Copyright Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags and
 * the COPYRIGHT.txt file distributed with this work.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.teiid.couchbase;

import javax.resource.cci.Connection;

import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;

/**
 * The Logical Hierarchy of a Couchbase cluster looks
 * <pre>
 *   Namespaces
 *       └── Keyspaces
 *              └──Documents
 * </pre>
 * A Keyspace is a set of JSON documents that may vary in structure, use a 
 * self-describing format, flexible Data Model, dynamic schemas. 
 * 
 * A {@code CouchbaseConnection} is a connection to a specific Couchbase Namespace,
 * build upon Couchbase N1QL, used to handle application-level operations
 * (SELECT/UPDATE/INSERT/DELETE) against the documents under a specific 
 * Couchbase Namespace.
 * 
 * @author kylin
 *
 */
public interface CouchbaseConnection extends Connection {
    
    /**
     * Returns the name of the  Namespace
     * @return
     */
    String getNamespace();
    
    /**
     * Executes the given N1QL statement, which returns a single <code>N1qlQueryResult</code> 
     * object.
     * @param query is a N1QL statement, analogous to a relational database SQL statement.  
     * @return returns a <code>N1qlQueryResult</code> object that contains the JSON objects 
     *         produced by the given query.
     */
    N1qlQueryResult executeQuery(String query);
    
    /**
     * Executes the given <code>N1qlQuery</code> object which represents a complex N1QL statement.
     * returns a single <code>N1qlQueryResult</code> object.
     * @param query is a <code>N1qlQuery</code> object which represents a complex N1QL statement.
     * @return returns a <code>N1qlQueryResult</code> object that contains the JSON objects 
     *         produced by the given query.
     */
    N1qlQueryResult executeQuery(N1qlQuery query);
    
    /**
     * Executes the given N1QL statement, which returns a single <code>N1qlQueryResult</code> 
     * object.
     * 
     * @param statement Any N1QL statement, like Insert, Select, Update, Delete, etc.
     * @return
     */
    N1qlQueryResult execute(String statement);
}