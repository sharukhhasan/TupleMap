package tuplemap.tuples;

import java.util.Collection;
import java.util.Iterator;

import tuplemap.base.Tuple;
import tuplemap.values.Value0;
import tuplemap.values.Value1;
import tuplemap.values.Value2;
import tuplemap.values.Value3;

/**
 * Created by Sharukh Hasan on 9/28/16
 *
 * Four-element tuple
 */
public final class Quartet<A,B,C,D> extends Tuple implements Value0<A>, Value1<B>, Value2<C>, Value3<D> {
    private static final long serialVersionUID = 2445136048617019549L;
    private static final int SIZE = 4;

    private final A val0;
    private final B val1;
    private final C val2;
    private final D val3;

    public static <A,B,C,D> Quartet<A,B,C,D> with(final A value0, final B value1, final C value2, final D value3) {
        return new Quartet<A,B,C,D>(value0,value1,value2,value3);
    }

    //Create tuple from array. Array has to have exactly four elements.
    public static <X> Quartet<X,X,X,X> fromArray(final X[] array) {
        if(array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if(array.length != 4) {
            throw new IllegalArgumentException("Array must have exactly 4 elements in order to create a Quartet. Size is " + array.length);
        }

        return new Quartet<X,X,X,X>(array[0],array[1],array[2],array[3]);
    }

    //Create tuple from collection. Collection has to have exactly four elements.
    public static <X> Quartet<X,X,X,X> fromCollection(final Collection<X> collection) {
        return fromIterable(collection);
    }

    //Create tuple from iterable. Iterable has to have exactly four elements.
    public static <X> Quartet<X,X,X,X> fromIterable(final Iterable<X> iterable) {
        return fromIterable(iterable, 0, true);
    }

    //Create tuple from iterable, starting from the specified index.
    public static <X> Quartet<X,X,X,X> fromIterable(final Iterable<X> iterable, int index) {
        return fromIterable(iterable, index, false);
    }

    private static <X> Quartet<X,X,X,X> fromIterable(final Iterable<X> iterable, int index, final boolean exactSize) {
        if(iterable == null) {
            throw new IllegalArgumentException("Iterable cannot be null");
        }

        boolean tooFewElements = false;

        X element0 = null;
        X element1 = null;
        X element2 = null;
        X element3 = null;

        final Iterator<X> iter = iterable.iterator();
        int i = 0;
        while(i < index) {
            if(iter.hasNext()) {
                iter.next();
            } else {
                tooFewElements = true;
            }
            i++;
        }

        if(iter.hasNext()) {
            element0 = iter.next();
        } else {
            tooFewElements = true;
        }

        if(iter.hasNext()) {
            element1 = iter.next();
        } else {
            tooFewElements = true;
        }

        if(iter.hasNext()) {
            element2 = iter.next();
        } else {
            tooFewElements = true;
        }

        if(iter.hasNext()) {
            element3 = iter.next();
        } else {
            tooFewElements = true;
        }

        if(tooFewElements && exactSize) {
            throw new IllegalArgumentException("Not enough elements for creating a Quartet (4 needed)");
        }

        if(iter.hasNext() && exactSize) {
            throw new IllegalArgumentException("Iterable must have exactly 4 available elements in order to create a Quartet.");
        }

        return new Quartet<X,X,X,X>(element0, element1, element2, element3);
    }

    public Quartet(final A value0, final B value1, final C value2, final D value3) {
        super(value0, value1, value2, value3);
        this.val0 = value0;
        this.val1 = value1;
        this.val2 = value2;
        this.val3 = value3;
    }

    public A getValue0() {
        return this.val0;
    }

    public B getValue1() {
        return this.val1;
    }

    public C getValue2() {
        return this.val2;
    }

    public D getValue3() {
        return this.val3;
    }

    @Override
    public int getSize() {
        return SIZE;
    }

    public Triplet<B,C,D> removeFrom0() {
        return new Triplet<B,C,D>(this.val1, this.val2, this.val3);
    }

    public Triplet<A,C,D> removeFrom1() {
        return new Triplet<A,C,D>(this.val0, this.val2, this.val3);
    }

    public Triplet<A,B,D> removeFrom2() {
        return new Triplet<A,B,D>(this.val0, this.val1, this.val3);
    }

    public Triplet<A,B,C> removeFrom3() {
        return new Triplet<A,B,C>(this.val0, this.val1, this.val2);
    }

    public <X> Quartet<X,B,C,D> setAt0(final X value) {
        return new Quartet<X,B,C,D>(value, this.val1, this.val2, this.val3);
    }

    public <X> Quartet<A,X,C,D> setAt1(final X value) {
        return new Quartet<A,X,C,D>(this.val0, value, this.val2, this.val3);
    }

    public <X> Quartet<A,B,X,D> setAt2(final X value) {
        return new Quartet<A,B,X,D>(this.val0, this.val1, value, this.val3);
    }

    public <X> Quartet<A,B,C,X> setAt3(final X value) {
        return new Quartet<A,B,C,X>(this.val0, this.val1, this.val2, value);
    }

    public <X0> Quintet<X0,A,B,C,D> addAt0(final X0 value0) {
        return new Quintet<X0,A,B,C,D>(value0, this.val0, this.val1, this.val2, this.val3);
    }

    public <X0> Quintet<A,X0,B,C,D> addAt1(final X0 value0) {
        return new Quintet<A,X0,B,C,D>(this.val0, value0, this.val1, this.val2, this.val3);
    }

    public <X0> Quintet<A,B,X0,C,D> addAt2(final X0 value0) {
        return new Quintet<A,B,X0,C,D>(this.val0, this.val1, value0, this.val2, this.val3);
    }

    public <X0> Quintet<A,B,C,X0,D> addAt3(final X0 value0) {
        return new Quintet<A,B,C,X0,D>(this.val0, this.val1, this.val2, value0, this.val3);
    }

    public <X0> Quintet<A,B,C,D,X0> addAt4(final X0 value0) {
        return new Quintet<A,B,C,D,X0>(this.val0, this.val1, this.val2, this.val3, value0);
    }

    public <X0> Quintet<X0,A,B,C,D> addAt0(final Single<X0> tuple) {
        return addAt0(tuple.getValue0());
    }

    public <X0> Quintet<A,X0,B,C,D> addAt1(final Single<X0> tuple) {
        return addAt1(tuple.getValue0());
    }

    public <X0> Quintet<A,B,X0,C,D> addAt2(final Single<X0> tuple) {
        return addAt2(tuple.getValue0());
    }

    public <X0> Quintet<A,B,C,X0,D> addAt3(final Single<X0> tuple) {
        return addAt3(tuple.getValue0());
    }

    public <X0> Quintet<A,B,C,D,X0> addAt4(final Single<X0> tuple) {
        return addAt4(tuple.getValue0());
    }

    public <X0> Quintet<A,B,C,D,X0> add(final X0 value0) {
        return addAt4(value0);
    }

    public <X0> Quintet<A,B,C,D,X0> add(final Single<X0> tuple) {
        return addAt4(tuple);
    }

}
