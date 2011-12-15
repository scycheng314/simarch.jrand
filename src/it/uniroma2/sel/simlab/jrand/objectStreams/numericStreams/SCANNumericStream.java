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

package it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams;

import it.uniroma2.sel.simlab.jrand.objectStreams.DeterministicStream;

/** Implements a Numeric Stream that proceeds sequentially by returning all the
 * numbers in a integer range. When the stream reaches the range upper limit,
 * the stream proceeds in the opposite direction. Similarly, when the stream reaches
 * the range lower limit, the stream proceeds in the up direction.
 *
 * @author Daniele Gianni
 */
public class SCANNumericStream implements NumericStream, DeterministicStream<Number> {
        
    protected Integer from;
    protected Integer to;
    
    protected Integer current;
    
    /** Creates a new instance of SCANNumericStream */
    public SCANNumericStream(final Integer from, final Integer to) {
        setCurrent(from);
        setFrom(from);
        setTo(to);
    }
    
    public Integer getNext() {
        
        if (current < to) {
            current++;
            return current;
        } else {
            setCurrent(from);
        }
        
        return current;
    }
    
    public void goTo(final long l) {        
        long offset = l % (to - from + 1);
        
        current = from + (int) offset;
    }
    
    protected void setCurrent(final Integer i) {
        current = i;
    }
    
    protected void setFrom(final Integer i) {
        from = i;
    }
    
    protected void setTo(final Integer i) {
        to = i;
    }
}
