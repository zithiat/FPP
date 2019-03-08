package day03;

public class StarProblem {

	public static void main(String[] args) {
		drawLeftRightTriangle(6);
		System.out.println();
		
		drawRightRightTriangle(6);
		System.out.println();
		
		drawIsoscelesTriangle(7);
		System.out.println();
		
		drawUpLeftRightTriangle(6);
		System.out.println();
		
		drawUpRightRightTriangle(6);
		System.out.println();
		
		drawUpDiamond(7);
		System.out.println();
		
		drawLeftIsoscelesTriangle(9);
		System.out.println();
		
		drawRightIsoscelesTriangle(9);
	}
	
	/**
	 * To draw a right triangle on left side
	 * Example:
	 * 		*
	 * 		**
	 * 		* *
	 * 		*  *
	 * 		*****
	 * @param num is the value for how many rows
	 */
	private static void drawLeftRightTriangle(int num) {
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (i != num - 1) {
					if (j == 0 || j == i) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				} else {
					System.out.print("*");
				}
			}
			// For the next row printing
			System.out.println();
		}
	}

	/**
	 * To draw a right triangle on right side
	 * Example:
	 * 				*
	 * 			   **
	 * 			  * *
	 * 			 *  *
	 * 			*****
	 * @param num is the value for how many rows
	 */
	private static void drawRightRightTriangle(int num) {
		for (int i = 0; i < num; i++) {
			for (int j = num - 1; j >= 0; j--) {
				if (i != num - 1) {
					if (j == 0 || j == i) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				} else {
					System.out.print("*");
				}
			}
			// For the next row printing
			System.out.println();
		}
	}
		
	/**
	 * To draw an isosceles triangle
	 * Example:
	 * 				*
	 * 			   * *
	 * 			  *   *
	 * 			 *******
	 * @param num is the value of the base, must be ODD number
	 */
	private static void drawIsoscelesTriangle(int num) {
		if (num % 2 == 0) {
			System.out.println("The input number must be ODD, system exits");
			System.exit(1);
		} else {
			int mid = num / 2;
			for (int i = 0; i < mid + 1; i++) {
				for (int j = 0; j < num; j++) {
					if (i != mid) { 
						if (j == (mid - i) || j == (mid + i)) {
							System.out.print("*");
						}
						else {
							System.out.print(" ");
						}
					} else {
						System.out.print("*");
					}
				}
				System.out.println();
			}
		}
	}
	
	/**
	 * To draw the up right triangle on left side
	 * Example:
	 * 		*****
	 * 		*  *
	 * 		* *
	 * 		**
	 * 		*
	 * @param num is the value of rows
	 */
	private static void drawUpLeftRightTriangle(int num) {
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (i == 0) {
					System.out.print("*");
				} else {
					if (j == 0 || j == num - i - 1) { // we need to deduce 1 because we count from 0
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			// For the next row printing
			System.out.println();
		}
	}
	
	/**
	 * To draw the up right triangle on right side
	 * Example:
	 * 			*****
	 * 			 *  *
	 * 			  * *
	 * 			   **
	 * 				*
	 * @param num is the value of rows
	 */
	private static void drawUpRightRightTriangle(int num) {
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (i == 0) {
					System.out.print("*");
				} else {
					if (j == i || j == num - 1) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			// For the next row printing
			System.out.println();
		}
	}
	
	/**
	 * To draw the diamond
	 * Example:
	 * 				*
	 * 			   * *
	 * 			  *   *
	 * 			 *     *
	 * 			  *   *
	 * 			   * *
	 * 				*
	 * @param num is the value of the length of the short diagonal
	 * 				must be ODD number
	 */
	private static void drawUpDiamond(int num) {
		if (num % 2 == 0) {
			System.out.println("The input number must be ODD, system exits");
			System.exit(1);
		} else {
			int mid = num / 2;
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < num; j++) {
					if (i < mid + 1) {
						if (j == (mid - i) || j == (mid + i)) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					} else {
						if (j == i - mid || j == num - 1 - (i - mid)) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					}
				} 
				System.out.println();		
			}
		}
	}
	
	/**
	 * To draw an isosceles triangle with the base on left side
	 * Example:
	 * 			*
	 * 			**
	 * 			* *
	 * 			*  *
	 * 			*   *
	 * 			*  *
	 * 			* *
	 * 			**
	 * 			*
	 * @param num is the value of the base length = 2 * diagonal length
	 * 		  		and must be ODD number
	 */
	private static void drawLeftIsoscelesTriangle(int num) {
		int mid = num / 2;
		if (num % 2 == 0) {
			System.out.println("The input number must be ODD, system exits");
			System.exit(1);
		} else {
			for (int i = 0; i < num; i++) {
				for (int j = 0; j <= mid + 1; j++) {
					if (j == 0) {
						System.out.print("*");
					} else {
						if (i <= mid) {
							if (j == i) {
								System.out.print("*");
							} else {
								System.out.print(" ");
							}
						} else {
							if (j == mid - (i - mid)) {
								System.out.print("*");
							} else {
								System.out.print(" ");
							}
						}
					}
				}
				// For the next row printing
				System.out.println();
			}
		}
	}
	
	/**
	 * To draw an isosceles triangle with the base on right side
	 * Example:
	 * 					*
	 * 				   **
	 * 				  * *
	 * 				 *  *
	 * 				*   *
	 * 				 *  *
	 * 				  * *
	 * 				   **
	 * 					*
	 * @param num is the value of the base length = 2 * diagonal length
	 * 				and must be ODD number
	 */
	private static void drawRightIsoscelesTriangle(int num) {
		int mid = num / 2;
		if (num % 2 == 0) {
			System.out.println("The input number must be ODD, system exits");
			System.exit(1);
		} else {
			for (int i = 0; i < num; i++) {
				for (int j = 0; j <= mid + 1; j++) {
					if (j == mid + 1) {
						System.out.print("*");
					} else {
						if (i <= mid) {
							if (j == mid - i + 1) {
								System.out.print("*");
							} else {
								System.out.print(" ");
							}
						} else {
							if (j == i - mid + 1) {
								System.out.print("*");
							} else {
								System.out.print(" ");
							}
						}
					}
				}
				System.out.println();
			}
		}
	}
}
