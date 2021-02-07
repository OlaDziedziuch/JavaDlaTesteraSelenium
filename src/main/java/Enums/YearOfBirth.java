package Enums;

public enum YearOfBirth {

    NONE("-"),
    C2021("2021"),
    P2020("2020"),
    P2019("2019"),
    P2018("2018"),
    P2017("2017"),
    P2016("2016"),
    P2015("2015"),
    P2014("2014"),
    P2013("2013"),
    P2012("2012"),
    P2011("2011"),
    P2010("2010"),

    P2009("2009"),
    P2008("2008"),
    P2007("2007"),
    P2006("2006"),
    P2005("2005"),
    P2004("2004"),
    P2003("2003"),
    P2002("2002"),
    P2001("2001"),
    P2000("2000"),

    P1999("1999"),
    P1998("1998"),
    P1997("1997"),
    P1996("1996"),
    P1995("1995"),
    P1994("1994"),
    P1993("1993"),
    P1992("1992"),
    P1991("1991"),
    P1990("1990"),

    P1989("1989"),
    P1988("1988"),
    P1987("1987"),
    P1986("1986"),
    P1985("1985"),
    P1984("1984"),
    P1983("1983"),
    P1982("1982"),
    P1981("1981"),
    P1980("1980"),

    P1979("1979"),
    P1978("1978"),
    P1977("1977"),
    P1976("1976"),
    P1975("1975"),
    P1974("1974"),
    P1973("1973"),
    P1972("1972"),
    P1971("1971"),
    P1970("1970"),

    P1969("1969"),
    P1968("1968"),
    P1967("1967"),
    P1966("1966"),
    P1965("1965"),
    P1964("1964"),
    P1963("1963"),
    P1962("1962"),
    P1961("1961"),
    P1960("1960"),

    P1959("1959"),
    P1958("1958"),
    P1957("1957"),
    P1956("1956"),
    P1955("1955"),
    P1954("1954"),
    P1953("1953"),
    P1952("1952"),
    P1951("1951"),
    P1950("1950"),

    P1949("1949"),
    P1948("1948"),
    P1947("1947"),
    P1946("1946"),
    P1945("1945"),
    P1944("1944"),
    P1943("1943"),
    P1942("1942"),
    P1941("1941"),
    P1940("1940"),

    P1939("1939"),
    P1938("1938"),
    P1937("1937"),
    P1936("1936"),
    P1935("1935"),
    P1934("1934"),
    P1933("1933"),
    P1932("1932"),
    P1931("1931"),
    P1930("1930"),

    P1929("1929"),
    P1928("1928"),
    P1927("1927"),
    P1926("1926"),
    P1925("1925"),
    P1924("1924"),
    P1923("1923"),
    P1922("1922"),
    P1921("1921"),
    P1920("1920"),

    P1919("1919"),
    P1918("1918"),
    P1917("1917"),
    P1916("1916"),
    P1915("1915"),
    P1914("1914"),
    P1913("1913"),
    P1912("1912"),
    P1911("1911"),
    P1910("1910"),

    P1909("1909"),
    P1908("1908"),
    P1907("1907"),
    P1906("1906"),
    P1905("1905"),
    P1904("1904"),
    P1903("1903"),
    P1902("1902"),
    P1901("1901"),
    P1900("1900");

    private String value;

    YearOfBirth(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}