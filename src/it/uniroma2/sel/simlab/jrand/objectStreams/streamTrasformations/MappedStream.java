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

import it.uniroma2.sel.simlab.jrand.objectStreams.numericStreams.numericStreamTrasformations.BoundedIntegerStream;
import java.util.ArrayList;
import java.util.List;

/** Defines a trasnformation of a set of streams that relies on a numeric stream
 * that determines which stream has to be used, at each getNext method invokation
 *
 * @author Daniele Gianni
 */
public class MappedStream<T> implements StreamTrasformation<T>{
    
    private List<T> map;
    private BoundedIntegerStream mixingStream;
    
    /** Creates a new instance of MappedStream */
    public MappedStream(final BoundedIntegerStream s) {
        setMixingStream(s);
        setMap(new ArrayList<T>(s.getUpperBound() - s.getLowerBound()));
    }
    
    public void addMapping(final Integer i, final T t) {
        map.add(i, t);
    }
    
    public T getNext() {
        return map.get(mixingStream.getNext()); 
    }
    
    public void goTo(final long l) {
        mixingStream.goTo(l);
    }
    
    protected void setMixingStream(final BoundedIntegerStream s) {
        mixingStream = s;
    }
    
    protected void setMap(List<T> l) {
        map = l;
    }
}
