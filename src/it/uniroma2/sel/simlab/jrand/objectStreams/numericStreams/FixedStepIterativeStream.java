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

/** Defines a function that increments iteratively of a fixed step. The stream
 * is given by the value of the function calculated at the increment.
 *
 * @author  Daniele Gianni
 */
public final class FixedStepIterativeStream extends IterativeStream {
    
    private double step;
        
    /** Creates a new instance of FixedStepIterativeStream */
    public FixedStepIterativeStream(final Function function, final double startingValue, final double step) {
        super(function, startingValue);
        setStep(step);
    }

    /*
     * returns the next value
     */
    protected void chooseNextValue() {
        setNextValue(getNextValue() + step);
    }       
    
    public void goTo(final long l) {
        setNextValue(getNextValue() + l * step);
    }
    
    private void setStep(final double d) {
        step = d;
    }
}
