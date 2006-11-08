/*
 * $Id: OidGenerator.java,v 1.1 2006-11-08 20:54:48 concentus Exp $
 * 
 * Copyright 2005 Sebastian Hasait
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.hasait.eclipse.ccg.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Sebastian Hasait (hasait at web.de)
 * @version $Revision: 1.1 $
 */
public final class OidGenerator {
   private static final int BLOCK_LENGTH = 8;

   private static final int BLOCK_COUNT = 3;

   private static final int ALL_BYTE_BITS = 0xff;

   /**
    * A set of recently generated OID, used to assure that no duplicates
    * are returned to client.
    */
   private final Set _recentOids = new HashSet();

   /**
    * The time the last OID was generated.
    */
   private long _lastMillis;

   /**
    * static instance variable for singleton pattern.
    */
   private static OidGenerator _Instance = null;

   /**
    * random number generator.
    */
   private final SecureRandom _seeder;

   /**
    * holds hex values of ip and object hash code.
    */
   private final String _middleString;

   /**
    * Construct a generator.
    */
   private OidGenerator() {
      // prepare for uuid generation
      // these items are instantiated only once here in the constructor to increase performance
      InetAddress inet = null;
      String hexInetAddress = "";
      String thisHashCode = "";
      try {
         inet = InetAddress.getLocalHost();
         byte[] bytes = inet.getAddress();
         hexInetAddress = hexFormat(getInt(bytes), BLOCK_LENGTH);
         thisHashCode = hexFormat(System.identityHashCode(this), BLOCK_LENGTH);
      } catch (UnknownHostException e) {
         // log the error as a warning only, even without a hostname,
         // everything will work as long as we're not in a cluster.
      } catch (Exception e) {
         // log the error as a warning only, even without a hostname,
         // everything will work as long as we're not in a cluster.
      }
      _middleString = hexInetAddress + thisHashCode;
      _seeder = new SecureRandom();
   }

   /**
    * Gets the unique instance (singleton pattern).
    *
    * @return instance
    */
   public static OidGenerator getInstance() {
      if (_Instance == null) {
         _Instance = new OidGenerator();
      }
      return _Instance;
   }

   /**
    * generates oid, checks to make sure unique and returns it
    *
    * @return guaranteed unique oid
    */
   public synchronized String getOid() {
      long currentMillis = System.currentTimeMillis();
      String oid = generateOid(currentMillis);
      if (currentMillis == _lastMillis) {
         while (_recentOids.contains(oid)) {
            oid = generateOid(currentMillis);
         }
      } else {
         _lastMillis = currentMillis;
         _recentOids.clear();
      }
      _recentOids.add(oid);
      return oid;
   }

   /**
    * generate a new oid. called only internally by getOid()
    *
    * @return oid
    */
   private String generateOid(final long pTimeNow) {
      // get time as unsigned int
      int timeLow = (int) pTimeNow & -1;
      // get next random number
      int random = _seeder.nextInt();
      // instantiate new oid with universally unique identifier
      return hexFormat(timeLow, BLOCK_LENGTH) + _middleString + hexFormat(random, BLOCK_LENGTH);
   }

   /**
    * convert integer i to hex format string with length j
    *
    * @param pInt integer to convert to hex format
    * @param pLength length of string desired (hex value padded with 0's as needed)
    * @return hex format string
    */
   private String hexFormat(final int pInt, final int pLength) {
      String s = Integer.toHexString(pInt);
      return padHex(s, pLength) + s;
   }

   /**
    * pad hex format string with trailing 0's to desired length
    *
    * @param pString hex format string to pad
    * @param pLength desired length of string
    * @return hex format string (s) padded with 0's to desired length
    */
   private String padHex(final String pString, final int pLength) {
      StringBuffer sb = new StringBuffer();
      if (pString.length() < pLength) {
         for (int j = 0; j < pLength - pString.length(); j++) {
            sb.append("0");
         }
      }
      return sb.toString();
   }

   /**
    * gets int from byte array
    *
    * @param pBytes byte array to convert to int
    * @return int
    */
   private int getInt(final byte[] pBytes) throws Exception {
      int i = 0;
      int j = BLOCK_LENGTH * BLOCK_COUNT;
      int l;
      for (int k = 0; j >= 0; k++) {
         l = pBytes[k] & ALL_BYTE_BITS;
         i += l << j;
         j -= BLOCK_LENGTH;
      }
      return i;
   }

   public static void main(final String[] pArgs) {
      System.out.println(OidGenerator.getInstance().getOid());
      System.exit(0);
   }
}