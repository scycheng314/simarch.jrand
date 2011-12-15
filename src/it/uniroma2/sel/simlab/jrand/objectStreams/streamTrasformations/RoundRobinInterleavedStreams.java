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

package it.uniroma2.sel.simlab.jrand.objectStreams.streamTrasformations;

import it.uniroma2.sel.simlab.jrand.objectStreams.ObjectStream;

/** Defines a stream that interleaves a set of input stream using a Round Robin
 * algorithm
 *
 * @author  Daniele Gianni
 */
public final class RoundRobinInterleavedStreams<T> extends InterleavedStream<T> {

    // the index of the next stream to be accessed
    private int turn;
    
    /** Creates a new instance of RoundRobinInterleavedStreams */
    public RoundRobinInterleavedStreams(final int i) {
        setTurn(i - 1);
    }
    
    protected ObjectStream<T> getNextStream() {
        return objectStreams.get(getTurn());
    }
    
    private int getTurn() {
        turn = (turn + 1) % (objectStreams.size());
        return turn;
    }
    
    public void goTo(final long l) {
        for (long i = 0; i < l; i++) getNext();
    }
    
    private void setTurn(final int i) {
        turn = i;
    }
    
}
