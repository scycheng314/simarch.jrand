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


/** Defines a round robin stream of integers, ie a stream that produces a sequence
 * of numbers between 0 and N - where N is a parameter
 *
 * @author gianni
 */
public class RoundRobin implements IntegerStream {

    private int n;

    private int current = 0;

    public RoundRobin(Integer i) {
        n = i;
    }

    public Integer getNext() {
        current = (current + 1) % n;
        return current;
    }

    public void goTo(long l) {
        for (long i = 0; i < l; i++) getNext();
    }
}
