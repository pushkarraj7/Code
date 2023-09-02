class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length() < 8) return false;

        ArrayList<Character> list = new ArrayList<>();
        for(int i=0; i<password.length(); i++){
            list.add(password.charAt(i));
        }

        boolean lowl = false;
        boolean upperl = false;
        boolean digit = false;
        boolean spChar = false;
        String special = "!@#$%^&*()-+";
        char previous = '.';
        for(int i=0; i<list.size(); i++){
            if(list.get(i) == previous){
                return false;
            }
            previous = list.get(i);
            if(list.get(i) >= 'a' && list.get(i) <= 'z'){
                lowl = true;
            }else if(list.get(i) >= 'A' && list.get(i) <= 'Z'){
                upperl = true;
            }else if(list.get(i) >= '0' && list.get(i) <= '9'){
                digit = true;
            }else if(special.indexOf(list.get(i)) != -1){
                spChar = true;
            }
        }
        return lowl && upperl && digit && spChar;
    }
}