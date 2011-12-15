/*
 * 	Copyright (C) 2005-2011 Department of Enteprise Engineering, University of Rome "Tor Vergata"
 *                              ( http://www.dii.uniroma2.it )
 *
 *      This file is part of SimArch and was developed at the Software Engineering Laboratory
 *      ( http://www.sel.uniroma2.it )
 *
 *      SimArch is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      (at your option) any later version.
 *
 *      SimArch is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with SimArch.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.numericStreamTrasformations;

import it.uniroma2.sel.simlab.jrand.objectStreams.streamTrasformations.ShuffledStream;
import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.NumericStream;

/** Shuffles a set of NumericStream to provide a NumericStream with more random properties
 *
 * @author  Daniele Gianni
 */
public class ShuffledNumericStream extends ShuffledStream<Number> implements NumericStream {
    
    public ShuffledNumericStream(final NumericStream o, final NumericStream s, final long l) {
        super(o, s, l);
    }    
}
