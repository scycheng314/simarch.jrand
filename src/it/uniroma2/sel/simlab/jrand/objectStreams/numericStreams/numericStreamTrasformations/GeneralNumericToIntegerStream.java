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

import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.IntegerStream;
import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.NumericStream;

/** Transforms a NumericStream into an IntegerStream, by operating an integer cast
 *
 * @author Daniele Gianni
 */
public final class GeneralNumericToIntegerStream implements IntegerStream {
    
    private NumericStream numericStream;
    
    /** Creates a new instance of GeneralNumericToIntegerStream */
    public GeneralNumericToIntegerStream(final NumericStream s) {
        setNumericStream(s);
    }
    
    public Integer getNext() {
        return numericStream.getNext().intValue();
    }
    
    public void goTo(final long l) {
        numericStream.goTo(l);
    }
    
    private void setNumericStream(final NumericStream s) {
        numericStream = s;
    }
}
