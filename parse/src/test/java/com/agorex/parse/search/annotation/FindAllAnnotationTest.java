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
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.agorex.parse.AbstractTest;
import com.agorex.parse.data.Data;

public final class FindAllAnnotationTest extends AbstractTest {

   @Test
   public void testFind() {
      for (int index = 0; index < super.getDataArraySize(); ++index) {
         assertTrue(super.getDataArrayData(index).getClassName() + " - Run failed", run(super.getDataArrayData(index)));
      }
   }


   private boolean run(final Data data) {
      final ResultSetAnnotation resultSetAnnotation;

      super.initialize(data.getStatement());

      resultSetAnnotation = FindAllAnnotation.find(super.getToken(), super.getResultSingleTokenRange(), data.getAllAnnotation().getAnnotation());

      assertEquals(data.getClassName() + " - Number of annotation ranges", data.getAllAnnotation().getSize(), resultSetAnnotation.getSize());

      for (int index = 0; index <= resultSetAnnotation.getSize(); ++index) {
         assertEquals(data.getClassName() + " - annotation", data.getAllAnnotation().getAnnotation(index), resultSetAnnotation.getAnnotation(index));
         assertEquals(data.getClassName() + " - token", data.getAllAnnotation().getToken(index), resultSetAnnotation.getToken(index));
      }

      return true;
   }
}
