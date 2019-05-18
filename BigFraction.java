//*********************************************************
// Big Fraction
// Author: RParkerE
// Date: 12/03/2014
//*********************************************************

import java.math.BigInteger;

public class BigFraction
{
  private final BigInteger num;
  private final BigInteger denom;
  public static final BigFraction ONE;
  public static final BigFraction ZERO;
  static
  {
    /**
     * This is the <code>BigFraction</code> constant 1/1
     */
    ONE = new BigFraction(1,1);
    /**
     * This is the <code>BigFraction</code> constant 0/1
     */
    ZERO = new BigFraction();
  }
  /**
   * This creates the big fraction _num/_denom
   * @param _num the numerator
   * @param _denom the denominator
   * throws IllegalArgumentException if the denominator
   * is zero
   */
  public BigFraction(BigInteger _num, BigInteger _denom)
  {
    if(_denom.compareTo(BigInteger.ZERO) < 0)
    {
      _num = _num.negate();
      _denom = _denom.negate();
    }
    BigInteger d = _num.gcd(_denom);
    num = _num.divide(d);
    denom = _denom.divide(d);
  }
  /**
   * This creates the big fraction a/b
   * @param a the numerator
   * @param b the denominator
   * throws IllegalArgumentException if the denominator
   * is zero
   */
  public BigFraction(long a, long b)
  {
    this(BigInteger.valueOf(a), BigInteger.valueOf(b));
  }
  public BigFraction()
  {
    this(0,1);
  }
  public String toString()
  {
    return "" + num + "/" + denom;
  }
  public boolean equals(Object o)
  {
    if(!(o instanceof BigFraction))
    {
      return false;
    }
    BigFraction that = (BigFraction) o;
    return (num.equals(that.num)) && (denom.equals(that.denom));
  }
  public BigFraction add(BigFraction that)
  {
    BigInteger top = num.multiply(that.denom).add(denom.multiply(that.num));
    BigInteger bottom = denom.multiply(that.denom);
    return new BigFraction(top, bottom);                                            
  }
  public BigFraction subtract(BigFraction that)
  {
    BigInteger top = num.multiply(that.denom).subtract(denom.multiply(that.num));
    BigInteger bottom = denom.multiply(that.denom);
    return new BigFraction(top, bottom);                                            
  }
  public BigFraction multiply(BigFraction that)
  {
    BigInteger top = num.multiply(that.num);
    BigInteger bottom = denom.multiply(that.denom);
    return new BigFraction(top, bottom);                                            
  }
  public BigFraction divide(BigFraction that)
  {
    BigInteger top = num.multiply(that.denom);
    BigInteger bottom = denom.multiply(that.num);
    return new BigFraction(top, bottom);                                            
  }
  public BigFraction pow(int n)
  {
    if(n==0)
    {
      return new BigFraction(1,1);
    }
    if(n < 0)
    {
      n = -n;
      return new BigFraction(denom.pow(n), num.pow(n));
    }
    return new BigFraction(num.pow(n), denom.pow(n));
  }
  public BigFraction negate()
  {
    return new BigFraction(num.negate(), denom);
  }
  public BigFraction abs()
  {
    return new BigFraction(num.abs(), denom);
  }
  public int compareTo(BigFraction that)
  {
    return num.multiply(that.denom).compareTo(denom.multiply(that.num));
  }
  public long longValue()
  {
    return num.divide(denom).longValue();
  }
  //bigIntegerValue
  public BigInteger bigIntegerValue()
  {
    return num.divide(denom);
  }
}
