class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int n = s.length();
        int res = n;

        int a = 0;
        int b = 0;
        int c = 0;
        int fromL = -1;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                a++;
            } else if (ch == 'b') {
                b++;
            } else c++;

            if (a >= k && b >= k && c >= k) {
                fromL = i + 1;
                break;
            }
        }
        if (fromL == -1) {
            return -1;
        }
        res = fromL;
        int l = fromL - 1;
        int r = n - 1;

        while (r >= 0 && l <= r) {
            char ch = s.charAt(r);

            if (ch == 'a') {
                a++;
            } else if (ch == 'b') {
                b++;
            } else c++;
            while (l >= 0 && a >= k && b >= k && c >= k) {
                char chl = s.charAt(l);
                res = Math.min(res, l + 1 + n - r);
                if (chl == 'a') {
                    a--;
                } else if (chl == 'b') {
                    b--;
                } else c--;

                l--;
            }


            r--;
        }


        a = 0;
        b = 0;
        c = 0;
        int fromR = -1;
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                a++;
            } else if (ch == 'b') {
                b++;
            } else c++;

            if (a >= k && b >= k && c >= k) {
                fromR = n - i;
                break;
            }
        }

        res = Math.min(res, fromR);
        r = n - fromR;
        l = 0;

        while (l < n && l <= r) {
            char ch = s.charAt(l);

            if (ch == 'a') {
                a++;
            } else if (ch == 'b') {
                b++;
            } else c++;
            while (r < n && a >= k && b >= k && c >= k) {
                char chr = s.charAt(r);
                res = Math.min(res, l + 1 + n - r);
                if (chr == 'a') {
                    a--;
                } else if (chr == 'b') {
                    b--;
                } else c--;

                r++;
            }


            l++;
        }

        return res;
    }
}