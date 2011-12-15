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

import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.NumericStream;


/** Operates a linear transformation on a Numeric Stream.
 *
 * @author  -
 */
public final class LinearTrasformation extends NumericStreamTrasformation {

    // the multiplicative coefficient
    private double a;

    // the additive coefficient
    private double b;    
   
    /** Creates a new instance of LinearTrasformation */
    public LinearTrasformation(final NumericStream s, final double coeff, final double offset) {
        setToTrasform(s);
        setA(coeff);
        setB(offset);
    }

    /*
     * Returns the max value that the stream can assume - currently this method is not implemented
     */
    public Number getMax() {
        return new Double(-1);
        //return new Double(getToTrasform().getMax().doubleValue() * a + b);
    }
    
    public Number getNext() {
        return new Double(a * (getToTrasform().getNext()).doubleValue() + b);
    }

    /*
     * Returns the original NumericStream that is transformed throught the linear
     * transformation defined by the coefficients
     */
    public NumericStream getToTrasform() {
        return numericStreams.get(0);
    }
    
    private void setA(final double i) {
        a = i;
    }
    
    private void setB(final double i) {
        b = i;
    }
    
    private void setToTrasform(final NumericStream s) {
        numericStreams.add(0, s);
    }       
}
