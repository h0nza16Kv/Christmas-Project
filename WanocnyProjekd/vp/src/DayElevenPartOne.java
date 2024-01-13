public class DayElevenPartOne {

    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public DayElevenPartOne(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Expands object coordinates based on xlist and ylist
     *
     * @param xlist An array containing the values the X
     * @param ylist An array containing the values the Y
     */
    public void expand(int[] xlist, int[] ylist) {
        int xz = 0;
        for (int x = 0; x < xlist.length; x++) {
            if (xlist[x] == 0 && this.x > x) {
                xz++;

            }
        }
        int yz = 0;
        for (int y = 0; y < xlist.length; y++) {
            if (ylist[y] == 0 && this.y > y) {
                yz++;
            }
        }
        this.x += xz;
        this.y += yz;
    }


    /**
     * You calculate the distance to another instance
     *
     * @param gal Target point
     * @return Distance to target point
     */
    public int lengthTo(DayElevenPartOne gal) {
        int xdiff = Math.abs(this.x - gal.x);
        int ydiff = Math.abs(this.y - gal.y);
        return xdiff + ydiff;
    }

}
