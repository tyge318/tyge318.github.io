class Solution(object):
    def findItinerary(self, tickets):
    	edges = collections.defaultdict(list)
    	for i in tickets:
    		begin = i[0]
    		end = i[1]
    		edges[begin].append(end)
    	def DFS(start):
            left, right = [], []
    	    output = [start]
            for i in sorted(edges[start]):
                if i not in edges[start]:
                    continue
                edges[start].remove(i)
                subroute = DFS(i)
                if start in subroute:
                    left.extend(subroute)
                else:
                    right.extend(subroute)
            output.extend(left)
            output.extend(right)
            return output
        return DFS('JFK')
    	