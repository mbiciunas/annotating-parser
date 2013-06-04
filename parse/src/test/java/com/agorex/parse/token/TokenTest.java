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
package com.agorex.parse.token;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.agorex.parse.AbstractTest;
import com.agorex.parse.data.Data;

/**
 * @author mbiciunas
 *
 */
public final class TokenTest extends AbstractTest {

   /**
    *
    */
   @Test
   public void testParse() {
      for (int index = 0; index < super.getDataArraySize(); ++index) {
         assertTrue(super.getDataArrayData(index).getClassName() + " - Run failed", process(super.getDataArrayData(index)));
      }
   }


   private boolean process(final Data data) {
      super.initialize(data.getStatement());

      assertEquals(data.getClassName() + " - Number of tokens", data.getToken().getSize(), super.getToken().getSize());

      for (int index = 0; index <= super.getToken().getSize(); ++index) {
         assertEquals(data.getClassName() + " - pointer start", data.getToken().getPointerStart(index), super.getToken().getStartPointer(index));
         assertEquals(data.getClassName() + " - pointer end", data.getToken().getPointerEnd(index), super.getToken().getEndPointer(index));
         assertEquals(data.getClassName() + " - annotation", data.getToken().getAnnotation(index), super.getToken().getAnnotation(index));
      }

      return true;
   }
}
