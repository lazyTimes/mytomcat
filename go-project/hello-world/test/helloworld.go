package main

import "fmt"

/**
go 语言快速入门
*/
func main() {
	fmt.Print("ssss")
	//test();
	//test2()
	test3()
}

//只能用于函数内部
//check := "aaaa"

/*
构建 变量的五种方式
1. var <name> <type>
*/
func test() {
	// 1. 第一种
	//var name string = "编程时光";
	//// 2. 第二种
	//var x, y int;
	//var (
	//	name string
	//	age int
	//	gender string
	//)
	//// 3. 推导声明写法或者短类型声明法：编译器会自动根据右值类型推断出左值的对应类型。
	//lll := "ss";
	//
	//// 第四种：声明和初始化多个变量
	//name, age := "wangbm", 28
	//
	//fmt.Print(name + age + gender)

	//第五种：new 函数声明一个指针变量
	//var i = new(int)
	//fmt.Print(i);

	fmt.Print("go lang hello world")

}

// 数据类型
func test2() {
	var mystr string = "hello"
	var mystr2 [5]byte = [5]byte{104, 101, 33}
	fmt.Printf("mystr %s:\n", mystr)
	fmt.Printf("mystr %s:\n", mystr2)
	country := "hello,中国"
	ss := `sadasdas
		dsa\r\n`
	fmt.Printf("ss" + ss)
	fmt.Printf("s解释 = %q", ss)
	fmt.Printf("\n len = %d", len(country))
}

// 数组
func test3() {
	arr1 := [...]int{1, 24, 2}
	arr2 := [...]int{1, 24, 2, 4}
	fmt.Printf("arr1 = %T\n", arr1)
	fmt.Printf("arr2 = %T", arr2)
	// 类型字面量
	type arr [3]int
	var myarr = arr{1, 2, 3}
	fmt.Printf(myarr)
}
