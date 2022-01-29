public class ProductKeyGen {

    private String oneRandomKey() {
        double num = Math.random();

        num *= 35;
        num = Math.round(num);

        if (num > 25)
            return String.valueOf((char) (num - 26 + '0'));
        else
            return String.valueOf((char) (num + 'A'));
    }

    public String generate(int length, char separator, int blockLength) {
        StringBuilder retVal = new StringBuilder(oneRandomKey());

        int blockCount = 0;
        int loopCount = 1;
        while (loopCount < length) {
            if (++blockCount >= blockLength) {
                retVal.append(separator);
                blockCount = 0;
            }
            retVal.append(oneRandomKey());
            loopCount++;
        }

        return retVal.toString();
    }

    public static void main(String[] args) {
        ProductKeyGen pkg = new ProductKeyGen();
        for(int i = 0; i < 100000000; ++i)
        {
            String key = pkg.generate(16, '-', 4);
                System.out.println(i+" = "+key);
        }
    }
}
