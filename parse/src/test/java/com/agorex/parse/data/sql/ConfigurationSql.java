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
package com.agorex.parse.data.sql;

import com.agorex.parse.token.ConfigurationData;


/**
 * @author mbiciunas
 *
 */
public final class ConfigurationSql {

   static final int ANNOTATION_NONE = 0;

   private static final int ANNOTATION_SPACE = 1;

   /**
    * Value for annotation of a single quote character.
    */
   public static final int ANNOTATION_QUOTE_SINGLE = 2;

   /**
    * Value for annotation of a double quote character.
    */
   public static final int ANNOTATION_QUOTE_DOUBLE = 3;

   /**
    * Value for annotation of a bracket open character.
    */
   public static final int ANNOTATION_BRACKET_OPEN = 4;

   /**
    * Value for annotation of a bracket close character.
    */
   public static final int ANNOTATION_BRACKET_CLOSE = 5;

   private static final int ANNOTATION_EQUAL = 6;
   private static final int ANNOTATION_COMMA = 7;
   private static final int ANNOTATION_BACKSLASH = 8;


   /**
    * Private constructor - all methods are static.
    */
   private ConfigurationSql() {
   }


   /**
    * @return parser configuration
    */
   public static ConfigurationData getConfiguration() {
      final ConfigurationData configurationData = new ConfigurationData(10);

      configurationData.add(' ', ANNOTATION_SPACE, ConfigurationData.ACTION_SKIP);
      configurationData.add('\'', ANNOTATION_QUOTE_SINGLE, ConfigurationData.ACTION_ANNOTATE);
      configurationData.add('"', ANNOTATION_QUOTE_DOUBLE, ConfigurationData.ACTION_ANNOTATE);
      configurationData.add('(', ANNOTATION_BRACKET_OPEN, ConfigurationData.ACTION_ANNOTATE);
      configurationData.add(')', ANNOTATION_BRACKET_CLOSE, ConfigurationData.ACTION_ANNOTATE);
      configurationData.add('=', ANNOTATION_EQUAL, ConfigurationData.ACTION_ANNOTATE);
      configurationData.add(',', ANNOTATION_COMMA, ConfigurationData.ACTION_ANNOTATE);
      configurationData.add('\\', ANNOTATION_BACKSLASH, ConfigurationData.ACTION_ANNOTATE);

      configurationData.setAnnotationQuoteSingle(ANNOTATION_QUOTE_SINGLE);
      configurationData.setAnnotationQuoteDouble(ANNOTATION_QUOTE_DOUBLE);
      configurationData.setAnnotationBracketOpen(ANNOTATION_BRACKET_OPEN);
      configurationData.setAnnotationBracketClose(ANNOTATION_BRACKET_CLOSE);

      return configurationData;
   }
}
