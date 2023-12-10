class Solution {
public:
    int mod = 1e9 + 7;
    
    int numberOfGoodPartitions(vector<int>& nums) {
        std::vector<int> partitionIndices;
        std::map<int, int> firstOccurences, lastOccurences;
        initializeOccurrences(nums, firstOccurences, lastOccurences);
        
        int currentIndex = 0, rightmostIndex = 0;
        findPartitionIndices(nums, firstOccurences, lastOccurences, partitionIndices, currentIndex, rightmostIndex);
        
        long long numberOfPartitions = partitionIndices.size();
        
        return calculateResult(numberOfPartitions);
    }
    
private:
    void initializeOccurrences(const std::vector<int>& nums, std::map<int, int>& firstOccurrences, std::map<int, int>& lastOccurrences) {
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            if (firstOccurrences.find(nums[i]) == firstOccurrences.end()) {
                firstOccurrences[nums[i]] = i;
            }
            lastOccurrences[nums[i]] = i;
        }
    }
    
    void findPartitionIndices(const std::vector<int>& nums, std::map<int, int>& firstOccurrences, std::map<int, int>& lastOccurrences, std::vector<int>& partitionIndices, int& currentIndex, int& rightmostIndex) {
        int size = nums.size();
        
        for (int i = 0; i < size; i++) {
            rightmostIndex = std::max(rightmostIndex, lastOccurrences.at(nums[i]));
            if (rightmostIndex == i) {
                partitionIndices.push_back(currentIndex);
                currentIndex = i + 1;
            }
        }
    }
    
    int calculateResult(long long numberOfPartitions) {
        long long result = 0, previousValue = 1;
        for (int i = 0; i < numberOfPartitions; i++) {
            result = previousValue % mod;
            previousValue = (previousValue + result) % mod;
        }
        
        return static_cast<int>(result);
    }
};