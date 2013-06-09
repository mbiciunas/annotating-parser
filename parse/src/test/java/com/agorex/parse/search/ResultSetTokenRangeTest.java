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
package com.agorex.parse.search;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author mbiciunas
 *
 */
public final class ResultSetTokenRangeTest {

   private static final int ANNOTATION_SELECT = 1;
   private static final TokenRange TOKEN_RANGE_SELECT = new TokenRange("select", 1, 2);
   private static final TokenRange TOKEN_RANGE_FROM = new TokenRange("from", 3, 4);
   private static final TokenRange TOKEN_RANGE_WHERE = new TokenRange("where", 5, 6);

   private transient ResultSetTokenRange resultSetTokenRange;


   /**
    *
    */
   @Before
   public void setUp() {
      resultSetTokenRange = new ResultSetTokenRange(2);
   }


   /**
    *
    */
   @Test
   public void testResultSetTokenRange() {
      resultSetTokenRange = new ResultSetTokenRange(2);

      assertEquals("Result set not right size", -1, resultSetTokenRange.getSize());
   }


   /**
    *
    */
   @Test
   public void testInitialize() {
      resultSetTokenRange.add(TOKEN_RANGE_SELECT.getTokenStart(), TOKEN_RANGE_SELECT.getTokenEnd());

      resultSetTokenRange.initialize();

      assertEquals("Result set not right size", -1, resultSetTokenRange.getSize());
   }


   /**
    *
    */
   @Test
   public void testGetSize() {
      resultSetTokenRange.add(TOKEN_RANGE_SELECT.getTokenStart(), TOKEN_RANGE_SELECT.getTokenEnd());

      assertEquals("Result set not right size", 0, resultSetTokenRange.getSize());
   }


   /**
    *
    */
   @Test
   public void testAddIntInt() {
      resultSetTokenRange.add(TOKEN_RANGE_SELECT.getTokenStart(), TOKEN_RANGE_SELECT.getTokenEnd());

      assertEquals("Token start value is wrong", TOKEN_RANGE_SELECT.getTokenStart(), resultSetTokenRange.getTokenRange(0).getTokenStart());
      assertEquals("Token end value is wrong", TOKEN_RANGE_SELECT.getTokenEnd(), resultSetTokenRange.getTokenRange(0).getTokenEnd());
   }


   /**
    *
    */
   @Test
   public void testAddCharArrayIntInt() {
      resultSetTokenRange.add(TOKEN_RANGE_SELECT.getName(), TOKEN_RANGE_SELECT.getTokenStart(), TOKEN_RANGE_SELECT.getTokenEnd());

      assertEquals("Token name is wrong", TOKEN_RANGE_SELECT.getName(), resultSetTokenRange.getTokenRange(0).getName());
      assertEquals("Token start value is wrong", TOKEN_RANGE_SELECT.getTokenStart(), resultSetTokenRange.getTokenRange(0).getTokenStart());
      assertEquals("Token end value is wrong", TOKEN_RANGE_SELECT.getTokenEnd(), resultSetTokenRange.getTokenRange(0).getTokenEnd());
   }


   /**
    *
    */
   @Test
   public void testAddIntIntInt() {
      resultSetTokenRange.add(ANNOTATION_SELECT, TOKEN_RANGE_SELECT.getTokenStart(), TOKEN_RANGE_SELECT.getTokenEnd());

      assertEquals("Token name is wrong", String.valueOf(ANNOTATION_SELECT), resultSetTokenRange.getTokenRange(0).getName());
      assertEquals("Token start value is wrong", TOKEN_RANGE_SELECT.getTokenStart(), resultSetTokenRange.getTokenRange(0).getTokenStart());
      assertEquals("Token end value is wrong", TOKEN_RANGE_SELECT.getTokenEnd(), resultSetTokenRange.getTokenRange(0).getTokenEnd());
   }


   /**
    *
    */
   @Test
   public void testGetTokenRange() {
      resultSetTokenRange.add(TOKEN_RANGE_SELECT.getTokenStart(), TOKEN_RANGE_SELECT.getTokenEnd());

      assertEquals("Token start value is wrong", TOKEN_RANGE_SELECT.getTokenStart(), resultSetTokenRange.getTokenRange(0).getTokenStart());
      assertEquals("Token end value is wrong", TOKEN_RANGE_SELECT.getTokenEnd(), resultSetTokenRange.getTokenRange(0).getTokenEnd());
   }


   /**
    *
    */
   @Test
   public void testFind() {
      TokenRange result;

      resultSetTokenRange.add(TOKEN_RANGE_SELECT.getName(), TOKEN_RANGE_SELECT.getTokenStart(), TOKEN_RANGE_SELECT.getTokenEnd());
      resultSetTokenRange.add(TOKEN_RANGE_FROM.getName(), TOKEN_RANGE_FROM.getTokenStart(), TOKEN_RANGE_FROM.getTokenEnd());
      resultSetTokenRange.add(TOKEN_RANGE_WHERE.getName(), TOKEN_RANGE_WHERE.getTokenStart(), TOKEN_RANGE_WHERE.getTokenEnd());

      result = resultSetTokenRange.find(TOKEN_RANGE_FROM.getName());

      assertEquals("Token name is wrong", TOKEN_RANGE_FROM.getName(), result.getName());
      assertEquals("Token start value is wrong", TOKEN_RANGE_FROM.getTokenStart(), result.getTokenStart());
      assertEquals("Token end value is wrong", TOKEN_RANGE_FROM.getTokenEnd(), result.getTokenEnd());
   }
}
