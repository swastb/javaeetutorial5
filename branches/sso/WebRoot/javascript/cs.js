<!--
/**
* CascadeSelect
* @version build 20050621 get lasted version from jinqinghua@gmail.com
* @author unkown [edited and optimized by Kim]
* @update 20051012 fixed some syntax errors
* @update 20060215 diplay it where select is multiple
*/

/**
* constructor
* @param object element as html element select
* @param array nodes that contains data in tree structure
* @param string parent as parent value
*/
function CascadeSelect(element, nodes, parent){
    this.form = element.form;
    this.tree = new Tree(nodes);
    
    this.subElement = "subElement";
    this.selectedValue = "selectedValue";
    this.defaultText = "defaultText";
    this.defaultValue = "defaultValue";

    this.build(element, parent, false);  
}

/**
* isHasDefault
* @param object element as html element select
* @return boolean true if succeed
*         boolean false if failed
*/
CascadeSelect.prototype.isHasDefault = function(element){
    return this.getUserCustomAttributeValue(element, this.defaultText) != null ? true : false;
}

/**
* isSubElementHasDefault
* @param object element as html element select
* @return boolean true if succeed
*         boolean false if failed
*/
CascadeSelect.prototype.isSubElementHasDefault = function(element){
    var subElement = this.getSubElement(element);
    if (subElement != "undefined"){//not typeof(subElement) != "undefined"
        return this.isHasDefault(subElement);
    }
}

/**
* setDefault
* @param object element as html element select
*/
CascadeSelect.prototype.setDefault = function(element){
    var defaultText = this.getUserCustomAttributeValue(element, this.defaultText);
    var defaultValue = this.getUserCustomAttributeValue(element, this.defaultValue);
    //defaultText = defaultText == null ? "" : defaultText
    defaultValue = defaultValue == null ? "" : defaultValue
    element.options[0] = new Option(defaultText, defaultValue);
}

/**
* build
* @param object element as html element select
* @param string parent as parent value
* @boolean buildSubOnly as if build sub element only
*/
CascadeSelect.prototype.build = function(element, parent, buildSubOnly){
    var tree = this.tree.filterTreeByParent(parent);
    var treeNodesLength = tree.nodes.length
    
    if(!buildSubOnly) {
        var blnIsHasDefault = this.isHasDefault(element);
        var selectedValue = this.getUserCustomAttributeValue(element, this.selectedValue);
        
        element.options.length = 0;
        //if (blnIsHasDefault && (treeNodesLength > 0 || this.isSubElementHasDefault(element))){
        if (blnIsHasDefault){
            this.setDefault(element);
        }
        for(var i = 0;i < treeNodesLength;i++) {
            //alert("text" + tree.nodes[i].option.text + "value:" + tree.nodes[i].option.value);
            if (blnIsHasDefault){
                element.options[i + 1] = new Option(tree.nodes[i].option.text,tree.nodes[i].option.value);
                if(selectedValue != null && tree.nodes[i].option.value == selectedValue) {
                    element.selectedIndex = i + 1;
                }
            } else {
                element.options[i] = new Option(tree.nodes[i].option.text,tree.nodes[i].option.value);
                if(selectedValue != null && tree.nodes[i].option.value == selectedValue) {
                    element.selectedIndex = i;
                }
            }

        }
    }
    if (element.options.length > 0){
        element.style.display = "";
        var subElement = this.getSubElement(element);
        //if (element.id == "selP4"){alert(subElement)}
        if (subElement != "undefined"){//not typeof(subElement) != "undefined"
            this.build(subElement, element.options[element.selectedIndex].value, false);
        }
    } else {
        this.setInvisible(element);
    }
}

/**
* getUserCustomAttributeValue
* @param object element as html element select
* @param string userCustomAttributeName as user custom attribute name
* @return string of attribute name if succeed
*         null null if failed
*/
CascadeSelect.prototype.getUserCustomAttributeValue = function(element, userCustomAttributeName){
    return element[userCustomAttributeName] ? element[userCustomAttributeName] : element.getAttribute(userCustomAttributeName);
}

/**
* getSubElement
* @param object element as html element select
* @return object as html element if succeed
*         string "undefined" if failed
*/
CascadeSelect.prototype.getSubElement = function(element){
    var subElementName = this.getUserCustomAttributeValue(element, this.subElement)
    if (subElementName == null){
        return "undefined"
    } else {
        return this.getElementByName(subElementName);
    }
}

/**
* setInvisible
* @param object element as html element select
*/
CascadeSelect.prototype.setInvisible = function (element){
	if (!element.multiple){
    	element.style.display = "none";
    }
    var subElement = this.getSubElement(element);
    if (subElement != "undefined"){//not typeof(subElement) != "undefined"
        this.setInvisible(subElement);
    }
}

/**
* get object by name - only return the first html element object
* @param string elementName as html element select name
* @return object as html element if succeed
*         string "undefined" if failed
*/
CascadeSelect.prototype.getElementByName = function(elementName) {
    for(var i = 0;i < this.form.elements.length;i++) {
        if(this.form.elements[i].name == elementName) {
            return this.form.elements[i];
        }
    }
    return "undefined";
}

/**
* handling event onchange
* @param object element as html element select
*/
CascadeSelect.prototype.change = function(element) {    
    this.build(element,element.options[element.selectedIndex].value,true);
}

/**
* Tree Constructor
* @param array nodes that contains data in TreeNode structure.
*/
function Tree(nodes) {
    this.nodes = nodes;
}

/**
* filterTreeByParent
* @param string parent as parent value
* @return ata in Tree structure.
*/
Tree.prototype.filterTreeByParent = function(parent){
    var aryTree = new Array();
    var j = 0;
    for(var i = 0; i < this.nodes.length; i++){
        if (typeof(this.nodes[i]) == "undefined" || this.nodes[i] == null){
            continue;
        }
        if (this.nodes[i].parent == parent){
            aryTree[j] = this.nodes[i];
            j++;
        }
    }
    return new Tree(aryTree);
}

/**
* constructor
* @param string parent as parent value
* @param string node as Option text
* @param string node as Option value
*/
function TreeNode(parent, text, value){
    this.parent = parent;
    this.option = new Option (text, value); //Option is a HTML Element Object
}
-->