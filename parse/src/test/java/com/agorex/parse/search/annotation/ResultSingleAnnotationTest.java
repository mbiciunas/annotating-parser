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

public final class ResultSingleAnnotationTest {

   private static final int ANNOTATION = 2;
   private static final int TOKEN = 4;

   private transient ResultSingleAnnotation resultSingleAnnotation;


   @Before
   public void setUp() {
      resultSingleAnnotation = new ResultSingleAnnotation(ANNOTATION, TOKEN);
   }


   @Test
   public void testResultSingleAnnotation() {
      assertEquals("Annotation not right", ANNOTATION, resultSingleAnnotation.getAnnotation());
      assertEquals("token not right", TOKEN, resultSingleAnnotation.getToken());
   }


   @Test
   public void testGetAnnotation() {
      assertEquals("Annotation not right", ANNOTATION, resultSingleAnnotation.getAnnotation());
   }


   @Test
   public void testGetToken() {
      assertEquals("token not right", TOKEN, resultSingleAnnotation.getToken());
   }

}
