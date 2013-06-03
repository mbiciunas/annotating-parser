/*
 * Copyright 2013 Mark Biciunas
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.agorex.parse.search.annotation;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.agorex.parse.data.sql.ConfigurationSql;

public final class ResultSetAnnotationTest {

   private static final int ANNOTATION_QUOTE_SINGLE = ConfigurationSql.ANNOTATION_QUOTE_SINGLE;
   private static final int ANNOTATION_QUOTE_DOUBLE = ConfigurationSql.ANNOTATION_QUOTE_DOUBLE;
   private static final int ANNOTATION_BRACKET_OPEN = ConfigurationSql.ANNOTATION_BRACKET_OPEN;
   private static final int ANNOTATION_BRACKET_CLOSE = ConfigurationSql.ANNOTATION_BRACKET_CLOSE;

   private static final int TOKEN_QUOTE_SINGLE = 1;
   private static final int TOKEN_QUOTE_DOUBLE = 2;
   private static final int TOKEN_BRACKET_OPEN = 3;
   private static final int TOKEN_BRACKET_CLOSE = 4;

   private transient ResultSetAnnotation resultSetAnnotation;


   @Before
   public void setUp() {
      resultSetAnnotation = new ResultSetAnnotation(2);
   }


   @Test
   public void testResultSetAnnotation() {
      resultSetAnnotation = new ResultSetAnnotation(2);

      assertEquals("Result set should be empty", -1, resultSetAnnotation.getSize());
   }


   @Test
   public void testInitialize() {
      resultSetAnnotation.add(ANNOTATION_QUOTE_SINGLE, TOKEN_QUOTE_SINGLE);

      resultSetAnnotation.initialize();

      assertEquals("Result set should be empty", -1, resultSetAnnotation.getSize());
   }


   @Test
   public void testGetSize() {
      resultSetAnnotation.add(ANNOTATION_QUOTE_SINGLE, TOKEN_QUOTE_SINGLE);

      assertEquals("Result set should be empty", 0, resultSetAnnotation.getSize());
   }


   @Test
   public void testGetAnnotation() {
      resultSetAnnotation.add(ANNOTATION_QUOTE_SINGLE, TOKEN_QUOTE_SINGLE);

      assertEquals("Annotation value is wrong", ANNOTATION_QUOTE_SINGLE, resultSetAnnotation.getAnnotation(0));
   }


   @Test
   public void testGetToken() {
      resultSetAnnotation.add(ANNOTATION_QUOTE_SINGLE, TOKEN_QUOTE_SINGLE);

      assertEquals("Token value is wrong", TOKEN_QUOTE_SINGLE, resultSetAnnotation.getToken(0));
   }


   @Test
   public void testAdd() {
      resultSetAnnotation.add(ANNOTATION_QUOTE_SINGLE, TOKEN_QUOTE_SINGLE);

      assertEquals("Annotation value is wrong", ANNOTATION_QUOTE_SINGLE, resultSetAnnotation.getAnnotation(0));
      assertEquals("Token value is wrong", TOKEN_QUOTE_SINGLE, resultSetAnnotation.getToken(0));
   }


   @Test
   public void testSort() {
      resultSetAnnotation.add(ANNOTATION_BRACKET_CLOSE, TOKEN_BRACKET_CLOSE);
      resultSetAnnotation.add(ANNOTATION_BRACKET_OPEN, TOKEN_BRACKET_OPEN);
      resultSetAnnotation.add(ANNOTATION_QUOTE_DOUBLE, TOKEN_QUOTE_DOUBLE);
      resultSetAnnotation.add(ANNOTATION_QUOTE_SINGLE, TOKEN_QUOTE_SINGLE);

      resultSetAnnotation.sort();

      assertEquals("Token value is wrong", TOKEN_QUOTE_SINGLE, resultSetAnnotation.getToken(0));
      assertEquals("Token value is wrong", TOKEN_QUOTE_DOUBLE, resultSetAnnotation.getToken(1));
      assertEquals("Token value is wrong", TOKEN_BRACKET_OPEN, resultSetAnnotation.getToken(2));
      assertEquals("Token value is wrong", TOKEN_BRACKET_CLOSE, resultSetAnnotation.getToken(3));
   }
}
