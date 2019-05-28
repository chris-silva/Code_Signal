
class Graph { 

        constructor(noOfVertices) 
        { 
                this.noOfVertices = noOfVertices; 
                this.AdjList = new Map(); 
        } 
        addVertex(v) 
        { 
		this.AdjList.set(v, []); 
	} 

	addEdge(v, w) 
	{ 
		this.AdjList.get(v).push(w); 
	} 
}

function longestPath(fileSystem) 
{
	let files = [];
	let index1 = 0;
	let index2 = 0;
	let temp = fileSystem;
        let word;
	
	while (temp !== null)
	{
		index2 = temp.search("\f");
                
		if (index2 == -1)
		{
			word = temp.substring(index1, temp.length);
			files.push(word);
			temp = null;
		}
		else
		{
			word = temp.substring(index1, index2);
			files.push(word);
			index1 = index2 + 1;
			temp = temp.substring(index1, temp.length);
                        index1 = 0;
		}
		
		
	}
	
	var g = new Graph(files.length); 
  
	// adding vertices 
	for (var i = 0; i < files.length; i++)
	{ 
		g.addVertex(files[i]); 
	} 
	
	let numOfTabs = 0;
	let numOfTabs2 = 0;
	let fileTemp;
	let charTemp;
	//constructing lists of adjacency list
	for (let i = 0; i < files.length; i++)
	{
		fileTemp = files[i];
		numOfTabs = countTabs(fileTemp);
		
		for (let j = i + 1; j < files.length; j++)
		{
			numOfTabs2 = countTabs(files[j]);
			
			if ( numOfTabs == (numOfTabs2 - 1) )
			{
				g.addEdge(files[i], files[j]); 
			}
			else if (numOfTabs == numOfTabs2)
			{
				break;
			}
		}
		
		numOfTabs = 0;
	}
	
	let allPosiblePaths = [];
	let onePathConstruction = "";

	let iterator2 = g.AdjList.keys();
	let verticeRoot;
	//let verticeRoot = iterator2.next().value;
	let sTemp = "";
	let stringMax = 0;
	
	//remember multiple roots
	for ( let x = 0; x < g.AdjList.size; x++)
	{
		verticeRoot = iterator2.next().value;
		if ( !verticeRoot.includes("\t") )
		{
			helper1(g, verticeRoot, onePathConstruction, allPosiblePaths);
		}
	}
	
	for ( let j = 0; j < allPosiblePaths.length; j++)
	{
		
		sTemp = allPosiblePaths[j];
		console.log("path: " + sTemp);
		if (sTemp.length > stringMax)
		{
			stringMax = sTemp.length;
		}
	}
	console.log(stringMax);
    return stringMax;
}

function helper1(myGraph, vertice, onePath, allPaths )
{
	
	let myArray = [];
	let key = null;
	let iterator1 = myGraph.AdjList.keys();
	let sTemp2 = "";
    
	//get the array of vertice
	for( let i = 0; i < myGraph.AdjList.size; i++)
	{
		key = iterator1.next().value;
		if ( key == vertice)
		{
			myArray = myGraph.AdjList.get(key);
		
		}
	}

	if (myArray.length == 0)
	{
		vertice = vertice.trim();
		onePath = onePath + vertice;
                if ( onePath.includes(".") )
	        {
		    allPaths.push(onePath);
                }
	}
	else
	{
		for ( let j = 0; j < myArray.length; j++)
		{
			vertice = vertice.trim();
                        if ( j == 0)
			{
			        onePath = onePath + vertice + "/";
                        }
			helper1(myGraph, myArray[j], onePath, allPaths );
			//onePath = "";
		}
	}
	
	
}


function countTabs(fileTemp)
{
	let num = 0;
	//counting number of tabs
	for ( let j = 0; j < fileTemp.length; j++ )
	{
		charTemp = fileTemp.charAt(j);

		if (charTemp === '\t')
		{
			num++;
		}
	}
    
        let tab = "";
	for ( let i = 0; i < fileTemp.length - 3; i++ )
	{
		tab = fileTemp.substring(i, i+4);
		
		if (tab === "    ")
		{
			num++;
		}
	}
        
	return num;
}
