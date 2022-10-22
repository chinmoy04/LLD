package com.src.behavioral.chainOfResponsibility;

abstract class Employee
{

	// next element in chain or responsibility
	protected Employee supervisor;

	public void setNextSupervisor( Employee supervisor )
	{
		this.supervisor = supervisor;
	}

	public abstract void applyLeave( String employeeName, int numberofDaysLeave );
}




class TeamLeader extends Employee
{
	// TeamLeader can only approve upto 10 days of leave
	private int MAX_LEAVES_CAN_APPROVE = 10;

	public void applyLeave( String employeeName, int numberofDaysLeave )
	{
		// check if TeamLeader can process this request
		if( numberofDaysLeave <= MAX_LEAVES_CAN_APPROVE )
		{
			ApproveLeave(employeeName, numberofDaysLeave);
		}
		// if TeamLeader can't process the LeaveRequest then pass on to the supervisor(ProjectLeader)
		// so that he can process
		else
		{
			supervisor.applyLeave(employeeName, numberofDaysLeave);
		}
	}

	private void ApproveLeave( String employeeName, int numberofDaysLeave )
	{
		System.out.println("TeamLeader approved " + numberofDaysLeave + " days " + "Leave for the employee : "
				+ employeeName);

	}
}



class ProjectLeader extends Employee
{
	// ProjectLeader can only approve upto 20 days of leave
	private int MAX_LEAVES_CAN_APPROVE = 20;

	public void applyLeave( String employeeName, int numberofDaysLeave )
	{
		// check if ProjectLeader can process this request
		if( numberofDaysLeave <= MAX_LEAVES_CAN_APPROVE )
		{
			ApproveLeave(employeeName, numberofDaysLeave);
		}
		// if ProjectLeader can't process the LeaveRequest then pass on to the supervisor(HR) 
		// so that he can process
		else
		{
			supervisor.applyLeave(employeeName, numberofDaysLeave);
		}
	}

	private void ApproveLeave( String employeeName, int numberofDaysLeave )
	{
		System.out.println("ProjectLeader approved " + numberofDaysLeave + " days " + "Leave for the employee : "
				+ employeeName);

	}
}




class HR extends Employee
{
	// HR can only approve upto 30 days of leave
	private int MAX_LEAVES_CAN_APPROVE = 30;

	public void applyLeave( String employeeName, int numberofDaysLeave )
	{
		if( numberofDaysLeave <= MAX_LEAVES_CAN_APPROVE )
		{
			ApproveLeave(employeeName, numberofDaysLeave);
		}
		else
		{
			System.out.println("Leave application suspended, Please contact HR");
		}
	}

	private void ApproveLeave( String employeeName, int numberofDaysLeave )
	{
		System.out.println("HR approved " + numberofDaysLeave + " days " + "Leave for the employee : "
				+ employeeName);

	}
}




public class ChainPatternDemo
{

	public static void main( String[] args )
	{
		TeamLeader teamLeader= new TeamLeader();
		ProjectLeader projectLeader= new ProjectLeader();
		HR hr=new HR();
		teamLeader.setNextSupervisor(projectLeader);
		projectLeader.setNextSupervisor(hr);

		teamLeader.applyLeave("David", 9);
		System.out.println();
		teamLeader.applyLeave("John", 18);
		System.out.println();
		teamLeader.applyLeave("Steve", 30);
		System.out.println();
		teamLeader.applyLeave("Rohan", 50);

	}

}

