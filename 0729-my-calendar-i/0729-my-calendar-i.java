class MyCalendar {
  public boolean book(int start, int end) {
    Integer low = timeline.lowerKey(end);

    if (low == null || timeline.get(low) <= start) {
      timeline.put(start, end);
      return true;
    }

    return false;
  }

  private TreeMap<Integer, Integer> timeline = new TreeMap<>();
}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */