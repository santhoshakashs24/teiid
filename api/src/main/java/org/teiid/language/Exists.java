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

package org.teiid.language;

import org.teiid.language.visitor.LanguageObjectVisitor;

/**
 * Represents an EXISTS criteria that checks whether any results would be
 * returned from a subquery.
 */
public class Exists extends Condition implements Predicate, SubqueryContainer {

    private QueryExpression query;

    public Exists(QueryExpression query) {
        this.query = query;
    }

    public QueryExpression getSubquery() {
        return query;
    }

    public void acceptVisitor(LanguageObjectVisitor visitor) {
        visitor.visit(this);
    }

    public void setSubquery(QueryExpression query) {
        this.query = query;
    }

}
