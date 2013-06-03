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
package com.agorex.parse.annotation;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.agorex.parse.AbstractTest;
import com.agorex.parse.annotation.AnnotationState.BracketState;
import com.agorex.parse.annotation.AnnotationState.QuoteState;
import com.agorex.parse.data.Data;

public final class AnnotationStateTest extends AbstractTest {

   @Test
   public void testGetBracketState() {
      assertEquals("Bracket state should be " + BracketState.CLOSE, BracketState.CLOSE, super.getStackAnnotation().getBracketState());
   }


   @Test
   public void testGetQuoteState() {
      assertEquals("Quote state should be " + QuoteState.NONE, QuoteState.NONE, super.getStackAnnotation().getQuoteState());
   }


   @Test
   public void testGetBracketStart() {
      assertEquals("Bracket start should be -1", -1, super.getStackAnnotation().getBracketStart());
   }


   @Test
   public void testGetBracketEnd() {
      assertEquals("Bracket end should be -1", -1, super.getStackAnnotation().getBracketEnd());
   }


   @Test
   public void testGetBracketDepth() {
      assertEquals("Bracket depth should be 0", 0, super.getStackAnnotation().getBracketDepth());
   }


   @Test
   public void testInitialize() {
      super.getStackAnnotation().initialize();

      assertSame("State should be normal", super.getStackAnnotation().getBracketState(), BracketState.CLOSE);
      assertSame("Quote should be none", super.getStackAnnotation().getQuoteState(), QuoteState.NONE);
      assertEquals("Bracket start should be -1", -1, super.getStackAnnotation().getBracketStart());
      assertEquals("Bracket end should be -1", -1, super.getStackAnnotation().getBracketEnd());
   }


   @Test
   public void testProcess() {
      for (int index = 0; index < super.getDataArraySize(); ++index) {
         assertTrue(super.getDataArrayData(index).getClassName() + " - Run failed", process(super.getDataArrayData(index)));
         process(super.getDataArrayData(index));
      }
   }


   private boolean process(final Data data) {
      int tokenCurrent;
      int annotation;

      super.initialize(data.getStatement());

      for (tokenCurrent = 0; tokenCurrent <= super.getToken().getSize(); tokenCurrent++) {
         annotation = super.getToken().getAnnotation(tokenCurrent);

         if (! super.getStackAnnotation().process(annotation, tokenCurrent, super.getParseData())) {
            break;
         }
      }

      assertEquals(data.getClassName() + " - Quote state", data.getAnnotation().getQuoteState(), super.getStackAnnotation().getQuoteState());
      assertEquals(data.getClassName() + " - Bracket state", data.getAnnotation().getBracketState(), super.getStackAnnotation().getBracketState());
      assertEquals(data.getClassName() + " - Bracket depth", data.getAnnotation().getBracketDepth(), super.getStackAnnotation().getBracketDepth());
      assertEquals(data.getClassName() + " - Bracket start", data.getAnnotation().getBracketStart(), super.getStackAnnotation().getBracketStart());
      assertEquals(data.getClassName() + " - Bracket end", data.getAnnotation().getBracketEnd(), super.getStackAnnotation().getBracketEnd());

      return true;
   }
}
