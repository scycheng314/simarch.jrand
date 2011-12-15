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

import it.uniroma2.sel.simlab.math.Function;

/** Define a stream that is determined iteratively, i.e. by using a stream number
 * to determine the next stream number
 *
 *
 * @author  Daniele Gianni
 */
public abstract class IterativeStream implements NumericStream {

    // function used for the iteration
    protected Function function;

    // next value
    private double nextValue;
        
    /** Creates a new instance of IterativeStream */
    public IterativeStream(final Function function, final double startingValue) {
        setFunction(function);
        setNextValue(startingValue);
    }
    
    protected abstract void chooseNextValue();
    
    public Number getNext() {
        Double toReturn = new Double(function.valueAt(nextValue));
        chooseNextValue();
        
        return toReturn;
    }    
    
    protected double getNextValue() {
        return nextValue;
    }
    
    public void goTo(final long l) {
        for (long i = 0; i < l; i++) getNext();
    }   
    
    protected void setFunction(final Function f) {
        function = f;
    }
    
    protected void setNextValue(final double d) {
        nextValue = d;
    }
    
    /*
    public Number getMax() {
        return new Double(function.getMax());
    }
    */
}
