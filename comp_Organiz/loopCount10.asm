	.ORIG	x3100
	LEA	R1,#100		
	AND	R5,R5,#0	;initialize R5 to 0
	AND	R6,R6,#0	;initialize R6 to 0
	LD	R6,VALUES	; set counter
;------------init values for loop--------------
	LDR	R2,R1,#0	;load value from memory to R2 form 
	ADD	R1,R1,#1	;address R1++
	ADD	R5,R5,R2	;R5+=R2
	ADD	R6,R6,#-1	;counter R6--
	BRp	#-5		;check condition if nzp = p back to LDR 
;--------------End loop-----------------
VALUES	.FILL	#10
	.END
	
