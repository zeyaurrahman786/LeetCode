class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        index1 = 0
        index2 = 1
        indices = []
        for i in range(len(nums)):
            for j in range(len(nums)):
                if i==j:
                    continue
                elif nums[i] + nums[j] == target:
                    index1 = i
                    index2 = j
                    indices.append(index1)
                    indices.append(index2)
                    break
            if len(indices) == 2:
                break
        return indices              

        

                    

        