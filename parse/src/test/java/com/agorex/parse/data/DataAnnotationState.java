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
package com.agorex.parse.data;

import com.agorex.parse.annotation.AnnotationState.BracketState;
import com.agorex.parse.annotation.AnnotationState.QuoteState;

public final class DataAnnotationState {

   private transient QuoteState quoteState;
   private transient BracketState bracketState;
   private transient int bracketDepth;
   private transient int bracketStart;
   private transient int bracketEnd;


   public QuoteState getQuoteState() { return quoteState; }
   public void setQuoteState(final QuoteState quoteState) { this.quoteState = quoteState; };

   public BracketState getBracketState() { return bracketState; }
   public void setBracketState(final BracketState bracketState) { this.bracketState = bracketState; };

   public int getBracketDepth() { return bracketDepth; }
   public void setBracketDepth(final int bracketDepth) { this.bracketDepth = bracketDepth; };

   public int getBracketStart() { return bracketStart; }
   public void setBracketStart(final int bracketStart) { this.bracketStart = bracketStart; };

   public int getBracketEnd() { return bracketEnd; }
   public void setBracketEnd(final int bracketEnd) { this.bracketEnd = bracketEnd; };
}
