class SnapshotArray {
    private List<TreeMap<Integer, Integer>> snapshots;
    private int snapId;

    public SnapshotArray(int length) {
        snapshots = new ArrayList<>();
        snapId = 0;
        for (int i = 0; i < length; i++) {
            snapshots.add(new TreeMap<>());
            snapshots.get(i).put(0, 0);
        }
    }

    public void set(int index, int val) {
        snapshots.get(index).put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        TreeMap<Integer, Integer> snapshot = snapshots.get(index);
        Integer val = snapshot.floorEntry(snapId).getValue();
        return val != null ? val : 0;
    }
}


/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */