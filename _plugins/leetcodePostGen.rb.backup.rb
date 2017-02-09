module Jekyll
	class LeetcodePage < Page
		def initialize(site, base, dir, title, content, cur_dir)
			@site = site
			@base = base
			@dir = dir
			@name = 'index.html'
			
			puts '@@dir = ' + dir
			self.process(@name)
			self.read_yaml(File.join(base, '_layouts'), 'leetcode.html')
			self.data['category'] = 'leetcode'
			self.data['title'] = title
			self.data['excerpt_separator'] = '<!--more-->'
		end
	end

	class LeetcodePostGenerator < Generator
		safe true
		
		def generate(site)
			path = site.config['leetCodeGen']
			if path 
				Dir.glob(path+'**/*.md') do |file|
					content = File.read(file)
					cur_dir = File.dirname(file)
					title = cur_dir.split('/').last
					outputPost = LeetcodePage.new(site, site.source, title, title, content, cur_dir)
					content += "\n<!--more-->"
					Dir.entries(cur_dir) do |item|
						next if item == '.' or item == '..'
						puts '@@item = ' + item
						if item.include? '.cpp'
							content += "\n### C++ Code:\n{% highlight cpp linenos %}"
						elsif item.include? '.java'
							content += "\n### Java Code:\n{% highlight java linenos %}"
						elsif item.include? '.py'
							content += "\n### Python Code:\n{% highlight python linenos %}"
						else
							next
						end		
						content += File.read(File.join(cur_dir, item) )
						content += "\n{% endhighlight %}"	
					end
					outputPost.content = content
					site.pages << outputPost
				end
			end
		end
	end
end
