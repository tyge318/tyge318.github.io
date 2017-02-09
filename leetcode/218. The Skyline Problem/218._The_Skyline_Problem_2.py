class Solution(object):
    def getSkyline(self, buildings):
        """
        :type buildings: List[List[int]]
        :rtype: List[List[int]]
        """
        edges = [];
        for i in buildings:
            edges.append([i[0], -i[2]])  #begin edge
            edges.append([i[1], i[2]]) #end edge
        edges.sort();
        
        ans = []
        pq = []
        heapq.heappush(pq, 0);
        prev = 0;
        reheapify = False
        for i in edges:
            if i[1] < 0:    #begin edge
                #heapq.heapify(pq)
                heapq.heappush(pq, i[1])
            if i[1] > 0:    #end edge
                if pq[0] == -i[1]:
                    heapq.heappop(pq)
                    if reheapify == True:
                        heapq.heapify(pq)
                        reheapify = False
                else:
                    pq.remove(-i[1])
                    reheapify = True
            current = pq[0]
            if current != prev:
                ans.append([i[0], -current])
                prev = current
        return ans
                