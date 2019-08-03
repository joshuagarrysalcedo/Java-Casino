
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import javax.swing.JOptionPane;
public class Casino{
    Scanner sc = new Scanner(System.in);
    Random randomNumbers = new Random();
	private int balance = 0;
	private int deposit = 0;
	private int totalDeposit = 0;
	
	//get time method
				public String getCurrentTime(){
					Date date = new Date();
					String strDateFormat = "hh:mm:ss a";
					DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
					String formattedDate = dateFormat.format(date);
					return formattedDate;
				}
				
	//withdraw method
	public void Withdraw(){
		if(balance > totalDeposit){
			JOptionPane.showMessageDialog(null, "-Total Deposit: $" + (float)totalDeposit + "\n-Withdrawal : $" + (float)balance + "\n-Net Profit: $" + ((float)balance - totalDeposit), "Profit", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(totalDeposit > balance){
			JOptionPane.showMessageDialog(null, "-Total Deposit: $" + (float)totalDeposit + "\n-Withdrawal : $" + (float)balance + "\n-Net Loss: $" + ((float)totalDeposit - balance), "Loss", JOptionPane.ERROR_MESSAGE);
		}
		JOptionPane.showMessageDialog(null, "You have successfully cashed out $" + (float)balance, "Cash out", JOptionPane.INFORMATION_MESSAGE);
		balance = balance - balance;
		totalDeposit = 0;
	}
	public void Deposit(){
		deposit = Integer.parseInt(JOptionPane.showInputDialog("Please enter deposit amount: "));
		balance += deposit;
		totalDeposit += deposit;
	}
    //method to display StartMenu
    public void displayStartmenu(){
		System.out.println("-------------------------------------");
		System.out.println("|"+getCurrentTime()+ "                        |");
		System.out.println("|credits: $" + balance + "                        |");
		System.out.println("+-----------------------------------+");
		System.out.println("|       Welcome to JAVA Casino!     |");
		System.out.println("|===================================|");
		System.out.println("|  1     -Deposit money             |");
		System.out.println("|  2     -Exit game                 |");
		System.out.println("|                                   |");
		System.out.println("+===================================+");
        System.out.print("Select an option: ");
        int optStartmenu = sc.nextInt();
            switch(optStartmenu){
                case 1:
                Deposit();
				JOptionPane.showMessageDialog(null, "You deposited $" + deposit);
                displayMainmenu();
                break;
                case 2:
				JOptionPane.showMessageDialog(null, "The Application will close!", "WARNING", JOptionPane.WARNING_MESSAGE);
				JOptionPane.showMessageDialog(null, "Thank you for playing!", "GOOD BYE!", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Thank you for playing!");
				
                System.exit(0);
				default:
				JOptionPane.showMessageDialog(null, "INVALID SELECTION! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
				displayStartmenu();
            }
    }
    
    public void displayMainmenu(){
		System.out.println("-------------------------------------");
		System.out.println(getCurrentTime());
		System.out.println("credits: $"+ balance);
		System.out.println("+-----------------------------------+");
		System.out.println("|       JAVA Casino Games           |");
		System.out.println("|===================================|");
		System.out.println("|  1     -Coin games                |");
		System.out.println("|  2     -Dice games                |");
		System.out.println("|  3     -Lotto games               |");
		System.out.println("|  4     -Cash out!                 |");
		System.out.println("|  5     -Deposit!                  |");
		System.out.println("|                                   |");
		System.out.println("+===================================+");
        System.out.print("Select an option: ");
        int optMainmenu = sc.nextInt();
            
            switch(optMainmenu){
                case 1:
                    displayCoingames();
                    break;
                case 2:
                    displayDicegames();
					break;
                case 3:
                    displayLottogames();
					break;
                case 4:
                    Withdraw();
                    displayStartmenu();
					break;
                case 5:
                    Deposit();
                    displayMainmenu();
					break;
                default:
                    JOptionPane.showMessageDialog(null, "INVALID SELECTION! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
                    displayMainmenu();
            }
       
    }
    
	
	//DISPLAY METHODS!
    public void displayCoingames(){
		JOptionPane.showMessageDialog(null, "Welcome to coin games!");
		System.out.println("-------------------------------------");
		System.out.println(getCurrentTime());
		System.out.println("credits: $"+ balance);
		System.out.println("+-----------------------------------+");
		System.out.println("|        Toss Coin!                 |");
		System.out.println("|===================================|");
		System.out.println("|  1     -play 1 coin               |");
		System.out.println("|  2     -play 2 coins              |");
		System.out.println("|  3     -play 3 coins              |");
		System.out.println("|  4     -Back                      |");
		System.out.println("|                                   |");
		System.out.println("+===================================+");
        System.out.print("Select an option: ");
        int optCoingames = sc.nextInt();
        
            switch(optCoingames){
                case 1:
                    displayOnecoin();
					break;
                case 2:
                    displayTwocoin();
					break;
                case 3:
                    displayThreecoin();
					break;
                case 4:
                    displayMainmenu();
					break;
				default:
				JOptionPane.showMessageDialog(null, "INVALID SELECTION! Please try again!", "Error", JOptionPane.ERROR_MESSAGE);
				displayCoingames();
            }
    }
                public void displayOnecoin(){
					System.out.println("-------------------------------------");
					System.out.println(getCurrentTime());
					System.out.println("credits: $"+ balance);
					System.out.println("+-----------------------------------+");
					System.out.println("|        play 1 Coin!               |");
					System.out.println("|===================================|");
					System.out.println("|  1     -how to play               |");
					System.out.println("|  2     -start game                |");
					System.out.println("|  3     -play Bingo style!         |");
					System.out.println("|  4     -back                      |");
					System.out.println("|                                   |");
					System.out.println("+===================================+"); 
                    System.out.print("Select an option: ");
                    int optOnecoin = sc.nextInt();
                        
                        switch(optOnecoin){
                            case 1:
								JOptionPane.showMessageDialog(null, "Heads or Tails? Correctly guess the toss coin\nand win 2 x wager!");
								displayOnecoin();
								break;
							case 2:
                                runOnecoin();
								break;
							case 3:
								runBingoOneCoin();
                            case 4:
                                displayCoingames();
								break;
							default:
								JOptionPane.showMessageDialog(null, "INVALID SELECTION! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
								displayOnecoin();
                        }
                   
                }
                
                public void displayTwocoin(){
					System.out.println("-------------------------------------");
					System.out.println(getCurrentTime());
					System.out.println("credits: $"+ balance);
					System.out.println("+-----------------------------------+");
					System.out.println("|        play 2 Coin!               |");
					System.out.println("|===================================|");
					System.out.println("|  1     -how to play               |");
					System.out.println("|  2     -start game                |");
					System.out.println("|  3     -play Bingo style!         |");
					System.out.println("|  4     -back                      |");
					System.out.println("|                                   |");
					System.out.println("+===================================+");
                    System.out.print("Select an option: ");
                    int optTwocoin = sc.nextInt();
					
                    
                        switch(optTwocoin){
                                case 1:
									JOptionPane.showMessageDialog(null, "Heads or Tails? 2 toss coins must be equal to your guess\nand win 3 x wager");
									displayTwocoin();
									break;
								case 2:
                                    runTwocoin();//two coin game method
									break;
								case 3:
									runBingoTwoCoin();
									break;
                                case 4:
                                    displayCoingames();
									break;
								default:
								JOptionPane.showMessageDialog(null, "INVALID SELECTION! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
								displayTwocoin();
                            }
                        
                    
                  
                }//end of Twocoin
                
                public void displayThreecoin(){
					System.out.println("-------------------------------------");
					System.out.println(getCurrentTime());
					System.out.println("credits: $"+ balance);
					System.out.println("+-----------------------------------+");
					System.out.println("|        play 3 Coin!               |");
					System.out.println("|===================================|");
					System.out.println("|  1     -how to play               |");
					System.out.println("|  2     -start game                |");
					System.out.println("|  3     -play Bingo style!         |");
					System.out.println("|  4     -back                      |");
					System.out.println("|                                   |");
					System.out.println("+===================================+");
                    System.out.print("Select an option: ");
                    int optThreecoin = sc.nextInt();
                    
                        switch(optThreecoin){
                            case 1:
								JOptionPane.showMessageDialog(null, "Heads or Tails? 3 toss coins must be equal to your guess\nand win 4 x wager");
								displayThreecoin();
								break;
							case 2:
                                runThreecoin();//one coin game method
								break;
							case 3:
								runBingoThreeCoin();
								break;	
                            case 4:
                                displayCoingames();
								break;
							default:
								JOptionPane.showMessageDialog(null, "INVALID SELECTION! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
								displayThreecoin();
                        }
                    
                }
    public void displayDicegames(){
		JOptionPane.showMessageDialog(null, "Welcome to Dice games!");
		System.out.println("-------------------------------------");
		System.out.println(getCurrentTime());
		System.out.println("credits: $"+ balance);
		System.out.println("+-----------------------------------+");
		System.out.println("|        Roll the Dice!             |");
		System.out.println("|===================================|");
		System.out.println("|  1     -play 1-dice               |");
		System.out.println("|  2     -play 2-dice               |");
		System.out.println("|  3     -play 3-dice               |");
		System.out.println("|  4     -Back                      |");
		System.out.println("|                                   |");
		System.out.println("+===================================+");
        System.out.print("Select an option: ");
        int optDicegames = sc.nextInt();
        
            switch(optDicegames){
                case 1:
                    displayOnedice();
					break;
                case 2:
                    displayTwodice();
					break;
                case 3:
                    displayThreedice();
					break;
                case 4:
                    displayMainmenu();
					break;
				default:
					JOptionPane.showMessageDialog(null, "INVALID SELECTION! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
					displayDicegames();
            }
    }
                
                public void displayOnedice(){
						System.out.println("-------------------------------------");
						System.out.println(getCurrentTime());
						System.out.println("credits: $"+ balance);
						System.out.println("+-----------------------------------+");
						System.out.println("|        1 Dice Game!                |");
						System.out.println("|===================================|");
						System.out.println("|  1     -How to play               |");
						System.out.println("|  2     -Play Guess(win 3x wager!) |");
						System.out.println("|  3     -Play Beat(win 2x wager)   |");
						System.out.println("|  4     -Bingo style!(Beat)        |");
						System.out.println("|  5     -Back                      |");
						System.out.println("|                                   |");
						System.out.println("+===================================+");
						System.out.print("Select an option: ");
						int optOnedice = sc.nextInt();
                    
                        switch(optOnedice){
							case 1:
								JOptionPane.showMessageDialog(null, "You have 2 Options in this game\nYou either guess or beat the roll of the casino", "How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "If you choose to guess the roll, you will be asked to make a guess on what the casino will roll! to win x 3 wager!", "Guess the roll", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "If you choose to beat the roll, You will be asked to roll the dice.\nIf your roll is higher than the casino's roll then you win x 2 wager!", "Beat the roll", JOptionPane.QUESTION_MESSAGE);
								displayOnedice();
								
								break;
                            case 2:
                                runOnediceGuess();
								break;
                            case 3:
                                runOnediceBeat();
								break;
							case 4:
								runBingoOneDice();
								break;
                            case 5:
                                displayDicegames();
								break;
							default:
								JOptionPane.showMessageDialog(null, "INVALID SELECTION! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
								displayOnedice();
                        }
                }
                
                public void displayTwodice(){
						System.out.println("-------------------------------------");
						System.out.println(getCurrentTime());
						System.out.println("credits: $"+ balance);
						System.out.println("+-----------------------------------+");
						System.out.println("|        2 Dice Game!                |");
						System.out.println("|===================================|");
						System.out.println("|  1     -How to play               |");
						System.out.println("|  2     -Play Guess(win 3x wager!) |");
						System.out.println("|  3     -Play Beat(win 2x wager!)  |");
						System.out.println("|  4     -Bingo style!(Beat)        |");
						System.out.println("|  5     -Back                      |");
						System.out.println("|                                   |");
						System.out.println("+===================================+");
				
						System.out.print("Select an option: ");
						int optTwodice = sc.nextInt();
                    
                        switch(optTwodice){
							case 1:
								JOptionPane.showMessageDialog(null, "You have 2 Options in this game\nYou either guess or beat the roll of the casino", "How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "If you choose to guess the roll, you will be asked to make a guess on what is the total sum/ of two dices based on the Casino's roll.\nCorrectly guessing will win you 3x wager!", "Guess the roll", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "If you choose to beat the roll, You will be asked to roll two dice.\nIf your total roll is higher than the casino's total roll then you win x 2 wager!", "Beat the roll", JOptionPane.QUESTION_MESSAGE);
								
                            case 2:
                                runTwodiceGuess();
								break;
                            case 3:
                                runTwodiceBeat();
								break;
							case 4:
								runBingoTwoDice();
                            case 5:
                                displayDicegames();
								break;
                            default:
								JOptionPane.showMessageDialog(null, "INVALID SELECTION! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
                                System.err.println("Invalid selection!Please try again");
                                displayTwodice();
                        }
                }
                
                public void displayThreedice(){
						System.out.println("-------------------------------------");
						System.out.println(getCurrentTime());
						System.out.println("credits: $"+ balance);
						System.out.println("+-----------------------------------+");
						System.out.println("|        3 Dice Game!                |");
						System.out.println("|===================================|");
						System.out.println("|  1     -How to play               |");
						System.out.println("|  2     -Play Guess(win 5x wager!) |");
						System.out.println("|  3     -Play Beat(win 2x wager!)  |");
						System.out.println("|  4     -Bingo style!(Beat)        |");
						System.out.println("|  5     -Back                      |");
						System.out.println("|                                   |");
						System.out.println("+===================================+");
						System.out.print("Select an option: ");
							int optThreedice = sc.nextInt();
                    
                        switch(optThreedice){
							case 1:
								JOptionPane.showMessageDialog(null, "You have 2 Options in this game\nYou either guess or beat the roll of the casino", "How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "If you choose to guess the roll, you will be asked to make a guess on what is the total sum/ of three dices based on the Casino's roll.\nCorrectly guessing will win you 5x wager!", "Guess the roll", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "If you choose to beat the roll, You will be asked to roll three dice.\nIf your total roll is higher than the casino's total roll then you win x 2 wager!", "Beat the roll", JOptionPane.QUESTION_MESSAGE);
								displayThreedice();
                            case 2:
                                runThreediceGuess();
								break;
                            case 3:
                                runThreediceBeat();
								break;
							case 4:
								runBingoThreeDice();
                            case 5:
                                displayDicegames();
								break;
                            default:
								JOptionPane.showMessageDialog(null, "INVALID SELECTION! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
                                System.err.println("Invalid selection!Please try again");
                                displayDicegames();
                        }
                }
                
    public void displayLottogames(){
		JOptionPane.showMessageDialog(null, "Welcome to Lotto Games!");
						System.out.println("-------------------------------------");
						System.out.println(getCurrentTime());
						System.out.println("credits: $"+ balance);
						System.out.println("+---------------------------------------------+");
						System.out.println("|        Lott Games!                          |");
						System.out.println("|=============================================|");
						System.out.println("|  1     -EZ2 Lotto!(win 200x wager!)         |");
						System.out.println("|  2     -Suertres Lotto!(win 300x wager!     |");
						System.out.println("|  3     -4 Digit Lotto!(win 400x wager)      |");
						System.out.println("|  4     -6/45 Mega Lotto!(Jackpot 30M!)      |");
						System.out.println("|  5     -6/55 Grand Lotto!(Jackpot 100M!)    |");
						System.out.println("|  6     -Back                                |");
						System.out.println("|                                             |");
						System.out.println("+=============================================+");
						System.out.print("Select an option: ");
						int optLottogames = sc.nextInt();
        
            switch(optLottogames){
                case 1:
                    displayEzlotto();
					break;
                case 2:
                    displayTreslotto();
					break;
                case 3:
                    displayFourlotto();
					break;
                case 4:
                    displayMegalotto();
					break;
                case 5:
                    displayGrandlotto();
					break;
                case 6:
                    displayMainmenu();
					break;
				default:
				JOptionPane.showMessageDialog(null, "INVALID SELECTION! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
				displayLottogames();
               
            }
    }
    
                public void displayEzlotto(){
						System.out.println("-------------------------------------");
						System.out.println(getCurrentTime());
						System.out.println("credits: $"+ balance);   
						System.out.println("+-----------------------------------+");
						System.out.println("|           EZ2 Lotto!              |");
						System.out.println("|===================================|");
						System.out.println("|  1     -How to play               |");
						System.out.println("|  2     -play Lucky pick!          |");
						System.out.println("|  3     -play Bet!                 |");
						System.out.println("|  4     -play Bingo style!         |");
						System.out.println("|  5     -Back                      |");
						System.out.println("|                                   |");
						System.out.println("+===================================+");
						System.out.print("Select an option: ");
						int optEZ = sc.nextInt();
                    
                        switch(optEZ){
							case 1:
								JOptionPane.showMessageDialog(null, "You have 2 options in this game\n Lucky pick or Bet", "How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "If you choose lucky pick, the Casino will generate 2 random numbers ranging from 0 - 9\n as your Lotto ticket","How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "If you choose bet, you will be asked to input a 2 digit-combination ranging from 0-9", "How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "Match your digit combination to the Casino's winning combination\nAnd win 200x wager", "How to play", JOptionPane.QUESTION_MESSAGE);
								displayEzlotto();
                            case 2:
                                runEzlottoLuckyPick();//run Lucky pick
								break;
                            case 3:
                                runEzlottoBet();
								break;
							case 4:
								runBingoEZlotto();
                            case 5:
                                displayLottogames();
								break;
                            default:
								JOptionPane.showMessageDialog(null, "INVALID SELECTION! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
                                System.err.println("Invalid Selection! Please try again");
                                displayEzlotto();
                          
                        }
                }
                
                public void displayTreslotto(){
						System.out.println("-------------------------------------");
						System.out.println(getCurrentTime());
						System.out.println("credits: $"+ balance);   
						System.out.println("+-----------------------------------+");
						System.out.println("|           Suertres Lotto!         |");
						System.out.println("|===================================|");
						System.out.println("|  1     -How to play               |");
						System.out.println("|  2     -play Lucky pick!          |");
						System.out.println("|  3     -play Bet!                 |");
						System.out.println("|  4     -play Bingo style!         |");
						System.out.println("|  5     -Back                      |");
						System.out.println("|                                   |");
						System.out.println("+===================================+");
						System.out.print("Select an option: ");
						int optTres = sc.nextInt();
                    
                        switch(optTres){
							case 1:
								JOptionPane.showMessageDialog(null, "You have 2 options in this game\n Lucky pick or Bet", "How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "If you choose lucky pick, the Casino will generate 3 random numbers ranging from 0 - 9\n as your Lotto ticket","How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "If you choose bet, you will be asked to input a 3 digit-combination ranging from 0-9", "How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "Match your digit combination to the Casino's winning combination\nAnd win 300x wager", "How to play", JOptionPane.QUESTION_MESSAGE);
								displayTreslotto();
                            case 2:
                                runSuertreslottoLuckyPick();
								break;
                            case 3:
                                runSuertresslottoBet();
								break;
							case 4:
								runBingoSuertreslotto();
                            case 5:
                                displayLottogames();
								break;
                            default:
								JOptionPane.showMessageDialog(null, "INVALID SELECTION! Please try again!", "Error", JOptionPane.ERROR_MESSAGE);
                                System.err.println("Invalid Selection! Please try again");
                                System.err.println("Invalid Selection! Please try again");
                                 displayTreslotto();
                          
                        }
                }
    
                public void displayFourlotto(){
						System.out.println("-------------------------------------");
						System.out.println(getCurrentTime());
						System.out.println("credits: $"+ balance);   
						System.out.println("+-----------------------------------+");
						System.out.println("|           4Digit Lotto!           |");
						System.out.println("|===================================|");
						System.out.println("|  1     -How to play               |");
						System.out.println("|  2     -play Lucky pick!          |");
						System.out.println("|  3     -play Bet!                 |");
						System.out.println("|  4     -play Bingo style!         |");
						System.out.println("|  5     -Back                      |");
						System.out.println("|                                   |");
						System.out.println("+===================================+");
						System.out.print("Select an option: ");
						int optFour = sc.nextInt();
                    
                        switch(optFour){
							case 1:
								JOptionPane.showMessageDialog(null, "You have 2 options in this game\n Lucky pick or Bet", "How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "If you choose lucky pick, the Casino will generate 4 random numbers ranging from 0 - 9\n as your Lotto ticket","How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "If you choose bet, you will be asked to input a 4 digit-combination ranging from 0-9", "How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "Match your digit combination to the Casino's winning combination\nAnd win 400x wager", "How to play", JOptionPane.QUESTION_MESSAGE);
								displayFourlotto();
								break;
                            case 2:
                                runFourDigitlottoLuckyPick();
								break;
                            case 3:
                                runFourDigitlottoBet();
								break;
							case 4:
								runBingoFourlotto();
                            case 5:
                                displayLottogames();
								break;
                            default:
								JOptionPane.showMessageDialog(null, "INVALID SELECTION! Please try again!", "Error", JOptionPane.ERROR_MESSAGE);
                                System.err.println("Invalid Selection! Please try again");
                                 displayFourlotto();
                          
                        }
                }
                
                public void displayMegalotto(){
						System.out.println("-------------------------------------");
						System.out.println(getCurrentTime());
						System.out.println("credits: $"+ balance);   
						System.out.println("+-----------------------------------+");
						System.out.println("|           6/45 Mega Lotto!        |");
						System.out.println("|===================================|");
						System.out.println("|  1     -How to play               |");
						System.out.println("|  2     -play Lucky pick!          |");
						System.out.println("|  3     -play Bet!                 |");
						System.out.println("|  4     -play Bingo style!         |");
						System.out.println("|  5     -Back                      |");
						System.out.println("|                                   |");
						System.out.println("+===================================+");
						System.out.print("Select an option: ");
					    int optMega = sc.nextInt();
                    
                        switch(optMega){
							case 1:
								JOptionPane.showMessageDialog(null, "You have 2 options in this game\n Lucky pick or Bet", "How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "If you choose lucky pick, the Casino will generate 6 random numbers ranging from 1 - 45\n as your Lotto ticket","How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "If you choose bet, you will be asked to input a 6 digit-combination ranging from 1-45", "How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "Match your digit combination to the Casino's winning combination\nAnd win the Jackpot prize of 30 MILLION!", "How to play", JOptionPane.QUESTION_MESSAGE);
								displayMegalotto();
                            case 2:
                                runMegalottoLuckyPick();
								break;
                            case 3:
                                runMegalottoBet();
								break;
							case 4:
								runBingoMegalotto();
                            case 5:
                                displayLottogames();
								break;
                            default:
								JOptionPane.showMessageDialog(null, "INVALID SELECTION! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
                                System.err.println("Invalid Selection! Please try again");
                                 displayMegalotto();
                          
                        }
                }
                
                public void displayGrandlotto(){
						System.out.println("-------------------------------------");
						System.out.println(getCurrentTime());
						System.out.println("credits: $"+ balance);   
						System.out.println("+-----------------------------------+");
						System.out.println("|           6/45 Grand Lotto!       |");
						System.out.println("|===================================|");
						System.out.println("|  1     -How to play               |");
						System.out.println("|  2     -Play Lucky pick!          |");
						System.out.println("|  3     -Play Bet!                 |");
						System.out.println("|  4     -play Bingo style!         |");
						System.out.println("|  5     -Back                      |");
						System.out.println("|                                   |");
						System.out.println("+===================================+");
						System.out.print("Select an option: ");
						int optGrand = sc.nextInt();
                    
                        switch(optGrand){
							case 1:
								JOptionPane.showMessageDialog(null, "You have 2 options in this game\n Lucky pick or Bet", "How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "If you choose lucky pick, the Casino will generate 6 random numbers ranging from 1 - 55\n as your Lotto ticket","How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "If you choose bet, you will be asked to input a 6 digit-combination ranging from 1-55", "How to play", JOptionPane.QUESTION_MESSAGE);
								JOptionPane.showMessageDialog(null, "Match your digit combination to the Casino's winning combination\nAnd win the Jackpot prize of 100 MILLION!", "How to play", JOptionPane.QUESTION_MESSAGE);
								displayGrandlotto();
                            case 2:
                                runGrandlottoLuckyPick();
								break;
                            case 3:
                                runGrandlottoBet();
								break;
							case 4:
								runBingoGrandlotto();
								break;
                            case 5:
                                displayLottogames();
								break;
                            default:
								JOptionPane.showMessageDialog(null, "INVALID SELECTION! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
                                System.err.println("Invalid Selection! Please try again");
                                 displayGrandlotto();
                          
                        }
                }
    
	
			//Coin games method!
			public void runOnecoin(){
				String oneCoin[] = {"Heads", "Tails"};	
				String userCoin[] = {"Heads", "Tails"};
				System.out.print("Please input your wager: ");
					int wager = sc.nextInt();
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					System.out.println("Insufficient funds! ");
					displayOnecoin();
				}
				else{
											System.out.print("1. Heads or 2. Tails?");
							int user = sc.nextInt();
							if(user < 1 || user > 2){
								JOptionPane.showMessageDialog(null, "INVALID SELECTION", "Error!", JOptionPane.WARNING_MESSAGE);
								runOnecoin();
							}
							
							 String guess = userCoin[user - 1];
							

						balance -= wager;	
						int result = randomNumbers.nextInt(oneCoin.length);
						System.out.println("-------------------------------------");
						System.out.println("Your guess is " + guess);
						System.out.println("=====================================");
						System.out.println("The coin toss is " + oneCoin[result]);
						System.out.println("-------------------------------------");
						if(oneCoin[result] == guess){
							int prize = wager * 2;
							System.out.println("Congratulations you won " + prize + " Pesos!");
							JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + "!");
							balance += prize;
							System.out.println();
							System.out.println();
							System.out.println();
							System.out.println();
							System.out.println();
						}
						else{
							
							JOptionPane.showMessageDialog(null, "Better luck next time!");
							System.out.println("-------------------------------------");
							System.err.println("Sorry you lost! Please try again!");
							System.out.println("-------------------------------------");
							System.out.println();
							System.out.println();
							System.out.println();
							System.out.println();
							System.out.println();
						}
				}
				displayOnecoin();
				
			}
			
			public void runTwocoin(){
				//The variable of casino's coin
				String firstCoin[] = {"Heads", "Tails"};
				String secondCoin[] = {"Heads", "Tails"};
				
				// the variable for the players coin
				String userCoin[] = {"Heads", "Tails"};
				
				//asks user to input wager
				System.out.print("Please input your wager: ");
					int wager = sc.nextInt();
				
				// if balance is less than the wager it will not be allowed to play
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					System.out.println("Insufficient funds! ");
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println();
					displayTwocoin();
				}
				
				else{
						
						System.out.print("1. Heads or 2. Tails?");
						System.out.println();
							int user = sc.nextInt();
						if(user < 1 || user > 2){
								JOptionPane.showMessageDialog(null, "INVALID SELECTION", "Error!", JOptionPane.WARNING_MESSAGE);
								runTwocoin();
							}
						String guess = userCoin[user - 1];// user - 1 because heads is 0 and tails is 1.
						
							
						
						// the first coin toss
						int result1 = randomNumbers.nextInt(firstCoin.length);
						// the second coin toss
						int result2 = randomNumbers.nextInt(firstCoin.length);
						balance -= wager;
						System.out.println("-------------------------------------");
						System.out.println("Your guess is " + guess);
						System.out.println("=====================================");
						System.out.println("First toss coin is " + firstCoin[result1]);
						System.out.println("Second toss coin is " + firstCoin[result2]);
						System.out.println("-------------------------------------");
						
						//winning condition
						if(firstCoin[result1] == guess && secondCoin[result2] == guess){
							int prize = wager * 3;
							System.out.println("-------------------------------------");
							System.out.println("Congratulations you won $" + prize + "!");
							System.out.println("-------------------------------------");
							JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + "!");
							balance += prize;
							System.out.println();
							System.out.println();
							System.out.println();
							System.out.println();
							System.out.println();
						}
						else{
							
							JOptionPane.showMessageDialog(null, "Better luck next time!");
							System.out.println("-------------------------------------");
							System.err.println("Sorry you lost! Please try again!");
							System.out.println("-------------------------------------");
							System.out.println();
							System.out.println();
							System.out.println();
							System.out.println();
							System.out.println();
						}
				}// end of first else
				displayTwocoin();
			}
			
			public void runThreecoin(){
				// these are the variables for the 3 coins of the casino
				String firstCoin[] = {"Heads", "Tails"};
				String secondCoin[] = {"Heads", "Tails"};
				String thirdCoin[] = {"Heads", "Tails"};
				
				String userCoin[] = {"Heads", "Tails"};// the variable for the player!
				System.out.println("-------------------------------------");
				System.out.print("Please input your wager: ");// ask user to input bett
					int wager = sc.nextInt();
				System.out.println("-------------------------------------");
				//if user has no more balance left it will not allowed to play
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					System.out.println("Insufficient funds! ");
					displayThreecoin();
				}
				else{
					
					System.out.print("1. Heads or 2. Tails?");
						int user = sc.nextInt();
						if(user < 1 || user > 2){
								JOptionPane.showMessageDialog(null, "INVALID SELECTION", "Error!", JOptionPane.WARNING_MESSAGE);
								runThreecoin();
							}
						String guess = userCoin[user - 1];// user - 1 because heads is 0 and tails is 1.
					
					
					
					// the first coin toss
					int result1 = randomNumbers.nextInt(firstCoin.length);
					// the second coin toss
					int result2 = randomNumbers.nextInt(firstCoin.length);
					//the third coin toss
					int result3 = randomNumbers.nextInt(firstCoin.length);
					balance -= wager;
					System.out.println("-------------------------------------");
					System.out.println("Your guess is " + guess); // display the guess of the user
					System.out.println("=====================================");
					System.out.println("First toss coin is " + firstCoin[result1]);
					System.out.println("Second toss coin is " + firstCoin[result2]);
					System.out.println("Third toss coin is " + firstCoin[result3]);
					System.out.println("-------------------------------------");
					
					//This is the winning condition.
					if((firstCoin[result1] == guess) && (secondCoin[result2] == guess) && (thirdCoin[result3] == firstCoin[result1])){
						
								int prize = wager * 4;
								System.out.println("-------------------------------------");
								System.out.println("Congratulations you won $" + prize);
								System.out.println("-------------------------------------");
								JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + " Pesos!");
								balance += prize;
							
						
					}						
					else{
						
						JOptionPane.showMessageDialog(null, "Better luck next time!");
						System.err.println("Sorry you lost! Please try again!");
						}
				}// end of first else
				displayThreecoin();
			}// end of runThreecoin();
			
			// Dice games method
			public void runOnediceGuess(){
				int casinoDice[] = {1, 2, 3, 4, 5, 6};
				int userDice[] = {1, 2, 3, 4, 5, 6};
				
				//Ask user how much is the wager
				System.out.print("How much is your wager: ?");
				int wager = sc.nextInt();
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					displayOnedice();
				}
				else{
				
				//Ask user what is the users guess
				System.out.print("What is your guess?: ");
				int user = sc.nextInt();
				if(user > 6 | user < 1){
					JOptionPane.showMessageDialog(null, "You can only guess from numbers 1 to 6!", "Error", JOptionPane.WARNING_MESSAGE);
					runOnediceGuess();
				}
						else{
						balance -= wager;
						int guess = userDice[user - 1]; // guess minus 1 because if user inputs 6, the index of 6 is 5. and so on.
						//the dice of the casino
						int casino = 0 + randomNumbers.nextInt(5);
						int result = casinoDice[casino];
						
						System.out.println("-------------------------------------");
						System.out.println("     Your guess is " + guess);
						System.out.println("     The casino's roll is " + result);
						System.out.println("-------------------------------------");
						
								if(guess == result){
									int prize = (wager * 3);
									balance += prize;
									JOptionPane.showMessageDialog(null, "Congratulations! You won $" + prize);
									System.out.println("You won!");
									displayOnedice();
								}
								else{
									
									JOptionPane.showMessageDialog(null, "Better luck next time!");
									System.out.println("You lost!");
									displayOnedice();
								}
					}//end of else
					}//end of else
			}
			public void runOnediceBeat(){
				int casinoDice[] = {1, 2, 3, 4, 5, 6};
				int userDice[] = {1, 2, 3, 4, 5, 6};
				
				//Ask user how much is the wager
				System.out.print("How much is your wager: ?");
				int wager = sc.nextInt();
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					displayOnedice();
				}
				else{	
				balance -= wager;
				//Ask user what is the users guess
				JOptionPane.showMessageDialog(null, "Please roll the dice!");
				//user rolls the dice
				int user = 0 + randomNumbers.nextInt(5);
				int guess = userDice[user]; // the value of the user's dice
				//the dice of the casino
				int casino = 0 + randomNumbers.nextInt(5);
				int result = casinoDice[casino];
				
				System.out.println("-------------------------------------");
				System.out.println("     Your dice is " + guess);
				System.out.println("     The casino's roll is " + result);
				System.out.println("-------------------------------------");
				
				if(guess > result){
					int prize = (wager * 2);
					balance += prize;
					JOptionPane.showMessageDialog(null, "Congratulations! You won $" + prize);
					System.out.println("You won!");
					displayOnedice();
				}
				else{
					
					JOptionPane.showMessageDialog(null, "Better luck next time!");
					System.out.println("You lost!");
					displayOnedice();
				}
			}
			}
			
			public void runTwodiceGuess(){
				int casinoDice1[] = {1, 2, 3, 4, 5, 6};
				int casinoDice2[] = {1, 2, 3, 4, 5, 6};
				
				
				//Ask user how much is the wager
				System.out.print("How much is your wager: ?");
				int wager = sc.nextInt();
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					displayTwodice();
				}
				else{
				
				//Ask user what is the users guess
				System.out.print("What is your guess?(min 2 max 12): ");
				int guess = sc.nextInt();				
				//the dice of the casino
						if(guess < 2 | guess > 12){
							JOptionPane.showMessageDialog(null, "You can only select from 2 to 12!", "Error", JOptionPane.WARNING_MESSAGE);
							displayTwodice();
						}
							else{
							balance -= wager;
							int casino = 0 + randomNumbers.nextInt(5);
							int result1 = casinoDice1[casino];
							casino = 0 + randomNumbers.nextInt(5);
							int result2 = casinoDice2[casino];
							//sum of casino's dice 1 and dice 2
							int sum = result1 + result2;
							System.out.println("-------------------------------------");
							System.out.println("     Your guess is " + guess);
							System.out.println("     The casino's roll is " + sum);
							System.out.println("-------------------------------------");
							
							if(guess == sum){
								int prize = (wager * 4);
								balance += prize;
								JOptionPane.showMessageDialog(null, "Congratulations! You won $" + prize);
								System.out.println("You won!");
								displayTwodice();
							}
							else{
									
								JOptionPane.showMessageDialog(null, "Better luck next time!");
								System.out.println("You lost!");
								displayTwodice();
							}
			}
			}
			}
			public void runTwodiceBeat(){
				int casinoDice1[] = {1, 2, 3, 4, 5, 6};
				int casinoDice2[] = {1, 2, 3, 4, 5, 6};
				int userDice1[] = {1, 2, 3, 4, 5, 6};
				int userDice2[] = {1, 2, 3, 4, 5, 6};
				
				//Ask user how much is the wager
				System.out.print("How much is your wager: ?");
				int wager = sc.nextInt();
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					displayTwodice();
				}
				else{
				balance -= wager;
				//Ask user what is the users guess
				JOptionPane.showMessageDialog(null, "Please roll the dice!");
				//user rolls the dice
				int user = 0 + randomNumbers.nextInt(5);
				int guess1 = userDice1[user]; // the value of the user's dice1
				user = 0 + randomNumbers.nextInt(5);
				int guess2 = userDice2[user];// dice 2
				// the total sum of user's dice 1 and dice 2
				int totalGuess = guess1 + guess2;
				
				//the dice of the casino
				int casino = 0 + randomNumbers.nextInt(5);
				int result1 = casinoDice1[casino];
				casino = 0 + randomNumbers.nextInt(5);
				int result2 = casinoDice2[casino];
				//the total sum of casino's dice1 and dice 2
				int totalResult = result1 + result2;
				
				System.out.println("-------------------------------------");
				System.out.println("     Your dice 1 is " + guess1);
				System.out.println("     Your dice 2 is " + guess2);
				System.out.println("     Player's total roll is " + totalGuess);
				System.out.println("     The casino's dice 1 is " + result1);
				System.out.println("     The casino's dice 2 is " + result2);
				System.out.println("     User's total roll is " + totalResult);
				System.out.println("-------------------------------------");
				
				if(totalGuess > totalResult){
					int prize = (wager * 3);
					balance += prize;
					JOptionPane.showMessageDialog(null, "Congratulations! You won $" + prize);
					System.out.println("You won!");
					displayTwodice();
				}
				else{
					
					JOptionPane.showMessageDialog(null, "Better luck next time!");
					System.out.println("You lost!");
					displayTwodice();
				}
			}
			}
			
			public void runThreediceGuess(){
				int casinoDice1[] = {1, 2, 3, 4, 5, 6};
				int casinoDice2[] = {1, 2, 3, 4, 5, 6};
				int casinoDice3[] = {1, 2, 3, 4, 5, 6};
				
				
				//Ask user how much is the wager
				System.out.print("How much is your wager: ?");
				int wager = sc.nextInt();
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					displayThreedice();
				}//end of if
				
				//Ask user what is the users guess
				System.out.print("What is your guess?(min 3 max 18): ");
				int guess = sc.nextInt();				
				//the dice of the casino
						if(guess < 3 | guess > 18){
							JOptionPane.showMessageDialog(null, "You can only select from 3 to 18!", "Error", JOptionPane.WARNING_MESSAGE);
							runThreediceGuess();	
						}// end of if
						balance -= wager;
											
							//first dice
							int casino = 0 + randomNumbers.nextInt(5);
							int result1 = casinoDice1[casino];
							//second dice
							casino = 0 + randomNumbers.nextInt(5);
							int result2 = casinoDice2[casino];
							//third dice
							casino = 0 + randomNumbers.nextInt(5);
							int result3 = casinoDice3[casino];
							//sum of casino's dice 1 and dice 2 and dice 3
							int sum = result1 + result2 + result3;
	
							System.out.println("-------------------------------------");
							System.out.println("     Your guess is " + guess);
							System.out.println("     The 1st dice is " + result1);
							System.out.println("     The 2nd dice is " + result2);
							System.out.println("     The 3rd dice is " + result3);
							System.out.println("     The total sum is " + sum);
							System.out.println("-------------------------------------");
													
							if(guess == sum){
								int prize = (wager * 5);
								balance += prize;
								JOptionPane.showMessageDialog(null, "Congratulations! You won $" + prize);
								System.out.println("You won!");
								displayThreedice();
								}
							else{
								
								JOptionPane.showMessageDialog(null, "Better luck next time!");
								System.out.println("You lost!");
								displayThreedice();
									}
						
			
			}// end of method
			
			public void runThreediceBeat(){
				int casinoDice1[] = {1, 2, 3, 4, 5, 6};
				int casinoDice2[] = {1, 2, 3, 4, 5, 6};
				int casinoDice3[] = {1, 2, 3, 4, 5, 6};
				int userDice1[] = {1, 2, 3, 4, 5, 6};
				int userDice2[] = {1, 2, 3, 4, 5, 6};
				int userDice3[] = {1, 2, 3, 4, 5, 6};
				
				//Ask user how much is the wager
				System.out.print("How much is your wager: ?");
				int wager = sc.nextInt();
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					displayThreedice();
				}
				else{
				balance -= wager;
				//Ask user what is the users guess
				JOptionPane.showMessageDialog(null, "Please roll the dice!");
				//user rolls the dice
				//dice 1
				int user = 0 + randomNumbers.nextInt(5);
				int guess1 = userDice1[user]; // the value of the user's dice1
				//dice 2
				user = 0 + randomNumbers.nextInt(5);
				int guess2 = userDice2[user];// dice 2
				//dice 3
				user = 0 + randomNumbers.nextInt(5);
				int guess3 = userDice3[user];
				// the total sum of user's dice 1 and dice 2 and dice 3
				int totalGuess = guess1 + guess2 + guess3;
				
				//the dice of the casino
				//dice 1
				int casino = 0 + randomNumbers.nextInt(5);
				int result1 = casinoDice1[casino];
				//dice 2
				casino = 0 + randomNumbers.nextInt(5);
				int result2 = casinoDice2[casino];
				//dice 3
				casino = 0 + randomNumbers.nextInt(5);
				int result3 = casinoDice3[casino];
				
				//the total sum of casino's dice1 and dice 2
				int totalResult = result1 + result2 + result3;
				
				System.out.println("-------------------------------------");
				System.out.println("     Your dice 1 is " + guess1);
				System.out.println("     Your dice 2 is " + guess2);
				System.out.println("     Your dice 3 is " + guess2);
				System.out.println("     Player's total roll is " + totalGuess);
				System.out.println("     The casino's dice 1 is " + result1);
				System.out.println("     The casino's dice 2 is " + result2);
				System.out.println("     The casino's dice 3 is " + result2);
				System.out.println("     Casino's total roll is " + totalResult);
				System.out.println("-------------------------------------");
				
				if(totalGuess > totalResult){
					int prize = (wager * 2);
					balance += prize;
					JOptionPane.showMessageDialog(null, "Congratulations! You won $" + prize);
					System.out.println("You won!");
					displayThreedice();
				}
				else{
					
					JOptionPane.showMessageDialog(null, "Better luck next time!");
					System.out.println("You lost!");
					displayThreedice();
				}
			}
			}

			//Lotto games method
			
			public void runEzlottoLuckyPick(){
				int luckypick[] = new int[2];
				int lottodraw[] = new int[2];
				System.out.println("-------------------------------------");
				System.out.println(" Prize is x 200 wager! ");
				System.out.println("-------------------------------------");
				System.out.println("How much is your wager ?");
				System.out.println("-------------------------------------");
				System.out.print("Please enter your wager ");
				int wager = sc.nextInt();
				System.out.println("-------------------------------------");
				
				//if wager is greater than balance
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					displayEzlotto();
				}//end of if
				else {
					balance -= wager;
					JOptionPane.showMessageDialog(null, "Lucky Pick is generating numbers for you", "EZ2 Lotto", JOptionPane.INFORMATION_MESSAGE);
					//Generate the numbers of luckypick
					luckypick[0] = 0 + randomNumbers.nextInt(9);
					luckypick[1] = 0 + randomNumbers.nextInt(9);
					System.out.println("-------------------------------------");
					System.out.println("Lucky pick Generated: " + Arrays.toString(luckypick));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "Lotto ticket : " + Arrays.toString(luckypick), "EZ2 Lotto", JOptionPane.INFORMATION_MESSAGE);
					
					//generate the numbers for the lotto draw
					JOptionPane.showMessageDialog(null, "The EZ2 Lotto draw will start after you click OK", "Lotto Draw", JOptionPane.WARNING_MESSAGE);
					for(int y = 0; y < lottodraw.length; y++){
						lottodraw[y] = 0 + randomNumbers.nextInt(9);
					}
					System.out.println("-------------------------------------");
					System.out.println("The winning combination is : " + Arrays.toString(lottodraw));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "The winning combination is : " + Arrays.toString(lottodraw), "EZ2 Lotto", JOptionPane.INFORMATION_MESSAGE);
					
					//decides wether the player wins or losses
						if(Arrays.equals(luckypick, lottodraw)){
							int prize = wager * 200;
							JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + "!", "Result", JOptionPane.INFORMATION_MESSAGE);
							System.out.println("-------------------------------------");
							System.out.println("     You won $" + prize);
							System.out.println("-------------------------------------");
							balance += prize;
							displayEzlotto();
						}//end of if
							else{
								
							System.out.println("-------------------------------------");
							System.out.println("     You lost!");
							System.out.println("-------------------------------------");	
								JOptionPane.showMessageDialog(null, "Better Luck Next time!", "Result", JOptionPane.INFORMATION_MESSAGE);
								displayEzlotto();
							}
						
				}//end of else
			}//end of runEzlottoLuckyPick method
		
			public void runEzlottoBet(){
				int playerbet[] = new int[2];
				int lottodraw[] = new int[2];
				System.out.println("-------------------------------------");
				System.out.println(" Prize is x 200 wager! ");
				System.out.println("-------------------------------------");
				System.out.println("How much is your wager ?");
				System.out.println("-------------------------------------");
				System.out.print("Please enter your wager ");
				int wager = sc.nextInt();
				System.out.println("-------------------------------------");
				
				//if wager is greater than balance
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					displayEzlotto();
				}//end of if
				else {
					
					JOptionPane.showMessageDialog(null, "Please enter your bet!", "EZ2 Lotto", JOptionPane.INFORMATION_MESSAGE);
					//Generate the numbers of luckypick
					System.out.println("-------------------------------------");
					System.out.println("What is your first no ?");
					System.out.println("-------------------------------------");
					System.out.print("Please enter your first no. ");
					playerbet[0] = sc.nextInt();
					System.out.println("-------------------------------------");
					//if player selects numbers below 0 and above 9
							if(playerbet[0] > 9 | playerbet[0] < 0){
								JOptionPane.showMessageDialog(null, "You can only select numbers 0 to 9! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
								runEzlottoBet();//go back from start
								}//end of if
					System.out.println("-------------------------------------");
					System.out.println("What is your second no ?");
					System.out.println("-------------------------------------");
					System.out.print("Please enter your second no. ");
					playerbet[1] = sc.nextInt();
					System.out.println("-------------------------------------");
					//if player selects numbers below 0 and above 9
							if(playerbet[1] > 9 | playerbet[1] < 0){
								JOptionPane.showMessageDialog(null, "You can only select numbers 0 to 9! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
								runEzlottoBet();//go back from start
								}//end of if
					System.out.println("-------------------------------------");
					System.out.println("Your bet is : " + Arrays.toString(playerbet));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "Lotto ticket : " + Arrays.toString(playerbet), "EZ2 Lotto", JOptionPane.INFORMATION_MESSAGE);
					
					//generate the numbers for the lotto draw
					balance -= wager;
					JOptionPane.showMessageDialog(null, "The EZ2 Lotto draw will start after you click OK", "Lotto Draw", JOptionPane.WARNING_MESSAGE);
					for(int y = 0; y < lottodraw.length; y++){
						lottodraw[y] = 0 + randomNumbers.nextInt(9);
					}
					System.out.println("-------------------------------------");
					System.out.println("The winning combination is : " + Arrays.toString(lottodraw));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "The winning combination is : " + Arrays.toString(lottodraw), "EZ2 Lotto", JOptionPane.INFORMATION_MESSAGE);
					
					//decides wether the player wins or losses
						if(Arrays.equals(playerbet, lottodraw)){
							int prize = wager * 200;
							balance += prize;
							JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + "!", "Result", JOptionPane.INFORMATION_MESSAGE);
							System.out.println("-------------------------------------");
							System.out.println("     You won $" + prize);
							System.out.println("-------------------------------------");
							balance += prize;
							displayEzlotto();
						}//end of if
							else{
							
							System.out.println("-------------------------------------");
							System.out.println("     You lost!");
							System.out.println("-------------------------------------");	
								JOptionPane.showMessageDialog(null, "Better Luck Next time!", "Result", JOptionPane.INFORMATION_MESSAGE);
								displayEzlotto();
							}
						
				}//end of else
			}//end of runEzlottoBet
		

			public void runSuertreslottoLuckyPick(){
				int luckypick[] = new int[3];
				int lottodraw[] = new int[3];
				System.out.println("-------------------------------------");
				System.out.println(" Prize is x 300 wager! ");
				System.out.println("-------------------------------------");
				System.out.println("How much is your wager ?");
				System.out.println("-------------------------------------");
				System.out.print("Please enter your wager ");
				int wager = sc.nextInt();
				System.out.println("-------------------------------------");
				
				//if wager is greater than balance
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					displayTreslotto();
				}//end of if
				else {
					balance -= wager;
					JOptionPane.showMessageDialog(null, "Lucky Pick is generating numbers for you", "EZ2 Suertres Lotto", JOptionPane.INFORMATION_MESSAGE);
					//Generate the numbers of luckypick
					luckypick[0] = 0 + randomNumbers.nextInt(9);
					luckypick[1] = 0 + randomNumbers.nextInt(9);
					luckypick[2] = 0 + randomNumbers.nextInt(9);
					System.out.println("-------------------------------------");
					System.out.println("Lucky pick Generated: " + Arrays.toString(luckypick));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "Lotto ticket : " + Arrays.toString(luckypick), "Suertres Lotto", JOptionPane.INFORMATION_MESSAGE);
					
					//generate the numbers for the lotto draw
					JOptionPane.showMessageDialog(null, "The EZ2 Lotto draw will start after you click OK", "Lotto Draw", JOptionPane.WARNING_MESSAGE);
					for(int y = 0; y < lottodraw.length; y++){
						lottodraw[y] = 0 + randomNumbers.nextInt(9);
					}
					System.out.println("-------------------------------------");
					System.out.println("The winning combination is : " + Arrays.toString(lottodraw));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "The winning combination is : " + Arrays.toString(lottodraw), "EZ2 Lotto", JOptionPane.INFORMATION_MESSAGE);
					
					//decides wether the player wins or losses
						if(Arrays.equals(luckypick, lottodraw)){
							int prize = wager * 300;
							JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + "!", "Result", JOptionPane.INFORMATION_MESSAGE);
							System.out.println("-------------------------------------");
							System.out.println("     You won $" + prize);
							System.out.println("-------------------------------------");
							balance += prize;
							displayTreslotto();
						}//end of if
							else{
								
							System.out.println("-------------------------------------");
							System.out.println("     You lost!");
							System.out.println("-------------------------------------");	
								JOptionPane.showMessageDialog(null, "Better Luck Next time!", "Result", JOptionPane.INFORMATION_MESSAGE);
								displayTreslotto();
							}
						
				}//end of else
			}//end of runEzlottoLuckyPick method
		
			public void runSuertresslottoBet(){
				int playerbet[] = new int[3];
				int lottodraw[] = new int[3];
				System.out.println("-------------------------------------");
				System.out.println(" Prize is x 300 wager! ");
				System.out.println("-------------------------------------");
				System.out.println("How much is your wager ?");
				System.out.println("-------------------------------------");
				System.out.print("Please enter your wager ");
				int wager = sc.nextInt();
				System.out.println("-------------------------------------");
				
				//if wager is greater than balance
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					displayEzlotto();
				}//end of if
				else {
					
					JOptionPane.showMessageDialog(null, "Please enter your bet!", "EZ2 Lotto", JOptionPane.INFORMATION_MESSAGE);
					//Asks user to input first number
									System.out.println("-------------------------------------");
									System.out.println("What is your first no ?");
									System.out.println("-------------------------------------");
									System.out.print("Please enter your first no. ");
									playerbet[0] = sc.nextInt();
									System.out.println("-------------------------------------");
					//if player selects numbers below 0 and above 9
							if(playerbet[0] > 9 | playerbet[0] < 0){
								JOptionPane.showMessageDialog(null, "You can only select numbers 0 to 9! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
								runSuertresslottoBet();//go back from start
								}//end of if
									System.out.println("-------------------------------------");
									System.out.println("What is your second no ?");
									System.out.println("-------------------------------------");
									System.out.print("Please enter your second no. ");
									playerbet[1] = sc.nextInt();
									System.out.println("-------------------------------------");
					//if player selects numbers below 0 and above 9
							if(playerbet[1] > 9 | playerbet[1] < 0){
								JOptionPane.showMessageDialog(null, "You can only select numbers 0 to 9! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
								runSuertresslottoBet();//go back from start
								}//end of if
									System.out.println("-------------------------------------");
									System.out.println("What is your third no ?");
									System.out.println("-------------------------------------");
									System.out.print("Please enter your third no. ");
									playerbet[2] = sc.nextInt();
									System.out.println("-------------------------------------");
					//if player selects numbers below 0 and above 9
							if(playerbet[2] > 9 | playerbet[0] < 0){
								JOptionPane.showMessageDialog(null, "You can only select numbers 0 to 9! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
								runSuertresslottoBet();//go back from start
								}//end of if
					System.out.println("-------------------------------------");
					System.out.println("Your bet is : " + Arrays.toString(playerbet));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "Lotto ticket : " + Arrays.toString(playerbet), " Suertres Lotto", JOptionPane.INFORMATION_MESSAGE);
					balance -= wager;
					//generate the numbers for the lotto draw
					JOptionPane.showMessageDialog(null, "The Suertres Lotto draw will start after you click OK", "Lotto Draw", JOptionPane.WARNING_MESSAGE);
					for(int y = 0; y < lottodraw.length; y++){
						lottodraw[y] = 0 + randomNumbers.nextInt(9);
					}
					System.out.println("-------------------------------------");
					System.out.println("The winning combination is : " + Arrays.toString(lottodraw));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "The winning combination is : " + Arrays.toString(lottodraw), "Suertres Lotto", JOptionPane.INFORMATION_MESSAGE);
					
					//decides wether the player wins or losses
						if(Arrays.equals(playerbet, lottodraw)){
							int prize = wager * 200;
							balance += prize;
							JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + "!", "Result", JOptionPane.INFORMATION_MESSAGE);
							System.out.println("-------------------------------------");
							System.out.println("     You won $" + prize);
							System.out.println("-------------------------------------");
							balance += prize;
							displayTreslotto();
						}//end of if
							else{
							
							System.out.println("-------------------------------------");
							System.out.println("     You lost!");
							System.out.println("-------------------------------------");	
								JOptionPane.showMessageDialog(null, "Better Luck Next time!", "Result", JOptionPane.INFORMATION_MESSAGE);
								displayTreslotto();
							}
						
				}//end of else
			}//end of runEzlottoBet

			public void runFourDigitlottoLuckyPick(){
				int luckypick[] = new int[4];
				int lottodraw[] = new int[4];
				System.out.println("-------------------------------------");
				System.out.println(" Prize is x 400 wager! ");
				System.out.println("-------------------------------------");
				System.out.println("How much is your wager ?");
				System.out.println("-------------------------------------");
				System.out.print("Please enter your wager ");
				int wager = sc.nextInt();
				System.out.println("-------------------------------------");
				
				//if wager is greater than balance
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					displayFourlotto();
				}//end of if
				else {
					balance -= wager;
					JOptionPane.showMessageDialog(null, "Lucky Pick is generating numbers for you", "Four Digit Lotto", JOptionPane.INFORMATION_MESSAGE);
					//Generate the numbers of luckypick
					luckypick[0] = 0 + randomNumbers.nextInt(9);
					luckypick[1] = 0 + randomNumbers.nextInt(9);
					luckypick[2] = 0 + randomNumbers.nextInt(9);
					luckypick[3] = 0 + randomNumbers.nextInt(9);
					System.out.println("-------------------------------------");
					System.out.println("Lucky pick Generated: " + Arrays.toString(luckypick));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "Lotto ticket : " + Arrays.toString(luckypick), "Four Digit Lotto", JOptionPane.INFORMATION_MESSAGE);
					
					//generate the numbers for the lotto draw
					JOptionPane.showMessageDialog(null, "The EZ2 Lotto draw will start after you click OK", "Four Digit Draw", JOptionPane.WARNING_MESSAGE);
					for(int y = 0; y < lottodraw.length; y++){
						lottodraw[y] = 0 + randomNumbers.nextInt(9);
					}
					System.out.println("-------------------------------------");
					System.out.println("The winning combination is : " + Arrays.toString(lottodraw));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "The winning combination is : " + Arrays.toString(lottodraw), "Four Digit Lotto", JOptionPane.INFORMATION_MESSAGE);
					
					//decides wether the player wins or losses
						if(Arrays.equals(luckypick, lottodraw)){
							int prize = wager * 300;
							JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + "!", "Result", JOptionPane.INFORMATION_MESSAGE);
							System.out.println("-------------------------------------");
							System.out.println("     You won $" + prize);
							System.out.println("-------------------------------------");
							balance += prize;
							displayFourlotto();
						}//end of if
							else{
							
							System.out.println("-------------------------------------");
							System.out.println("     You lost!");
							System.out.println("-------------------------------------");	
								JOptionPane.showMessageDialog(null, "Better Luck Next time!", "Result", JOptionPane.INFORMATION_MESSAGE);
								displayFourlotto();
							}
						
				}//end of else
			}//end of 4Digit Lotto method
		
			public void runFourDigitlottoBet(){
				int playerbet[] = new int[4];
				int lottodraw[] = new int[4];
				System.out.println("-------------------------------------");
				System.out.println(" Prize is x 400 wager! ");
				System.out.println("-------------------------------------");
				System.out.println("How much is your wager ?");
				System.out.println("-------------------------------------");
				System.out.print("Please enter your wager ");
				int wager = sc.nextInt();
				System.out.println("-------------------------------------");
				
				//if wager is greater than balance
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					displayFourlotto();
				}//end of if
				
				else{
					for(int i = 0; i < playerbet.length; i++){
						System.out.println("-------------------------------------");
						System.out.print("Please enter your digit no." + (i + 1) + " : ");
						playerbet[i] = sc.nextInt();
						System.out.println("-------------------------------------");
							if(playerbet[i] > 9 | playerbet[i] < 0){
								JOptionPane.showMessageDialog(null, "You can only select numbers 0 to 9! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
								runFourDigitlottoBet();
							}
					}//end for
					//print the user bet
					balance -= wager;
					System.out.println("-------------------------------------");
					System.out.println("Your lotto ticket: " + Arrays.toString(playerbet));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "Lotto ticket : " + Arrays.toString(playerbet), "Four Digit Lotto", JOptionPane.INFORMATION_MESSAGE);

					//generate the numbers for the lotto draw
					JOptionPane.showMessageDialog(null, "The EZ2 Lotto draw will start after you click OK", "Lotto Draw", JOptionPane.WARNING_MESSAGE);
					for(int y = 0; y < lottodraw.length; y++){
						lottodraw[y] = 0 + randomNumbers.nextInt(9);
					}
					System.out.println("-------------------------------------");
					System.out.println("The winning combination is : " + Arrays.toString(lottodraw));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "The winning combination is : " + Arrays.toString(lottodraw), "Four Digit Lotto", JOptionPane.INFORMATION_MESSAGE);
					
					//Finds out if the user won or lost
					if(Arrays.equals(playerbet, lottodraw)){
							int prize = wager * 400;
							JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + "!", "Result", JOptionPane.INFORMATION_MESSAGE);
							System.out.println("-------------------------------------");
							System.out.println("     You won $" + prize);
							System.out.println("-------------------------------------");
							balance += prize;
							displayFourlotto();
						}//end of if
							else{
							
							System.out.println("-------------------------------------");
							System.out.println("     You lost!");
							System.out.println("-------------------------------------");	
								JOptionPane.showMessageDialog(null, "Better Luck Next time!", "Result", JOptionPane.INFORMATION_MESSAGE);
								displayFourlotto();
								
							}
		
				}//end of else

			}//end of runFourDigitlottoBet

			public void runMegalottoLuckyPick(){
				int luckypick[] = new int[6];
				int lottodraw[] = new int[6];
				System.out.println("-------------------------------------");
				System.out.println("The ticket price is $20");
				System.out.println("The Jackpot price is $30,000,000");
				System.out.println("-------------------------------------");
				JOptionPane.showMessageDialog(null, "Ticket price is $20", "Price", JOptionPane.INFORMATION_MESSAGE);
				int wager = 20;
				//if wager is greater than balance
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					displayMegalotto();
				}//end of if
				else {
					balance -= wager;
					JOptionPane.showMessageDialog(null, "Lucky Pick is generating numbers for you", "6/45 Mega Lotto!", JOptionPane.INFORMATION_MESSAGE);
					//Generate the numbers of luckypick
					luckypick[0] = 1 + randomNumbers.nextInt(45);
					luckypick[1] = 1 + randomNumbers.nextInt(45);
					luckypick[2] = 1 + randomNumbers.nextInt(45);
					luckypick[3] = 1 + randomNumbers.nextInt(45);
					luckypick[4] = 1 + randomNumbers.nextInt(45);
					luckypick[5] = 1 + randomNumbers.nextInt(45);
					System.out.println("-------------------------------------");
					System.out.println("Lucky pick Generated: " + Arrays.toString(luckypick));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "Lotto ticket : " + Arrays.toString(luckypick), "6/45 Mega Lotto!", JOptionPane.INFORMATION_MESSAGE);
					
					//generate the numbers for the lotto draw
					JOptionPane.showMessageDialog(null, "The 6/45 Mega Lotto draw will start after you click OK", "6/45 Mega Lotto!", JOptionPane.WARNING_MESSAGE);
					for(int y = 0; y < lottodraw.length; y++){
						lottodraw[y] = 1 + randomNumbers.nextInt(45);
					}
					System.out.println("-------------------------------------");
					System.out.println("The winning combination is : " + Arrays.toString(lottodraw));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "The winning combination is : " + Arrays.toString(lottodraw), "6/45 Mega Lotto", JOptionPane.INFORMATION_MESSAGE);
					
					//decides wether the player wins or losses
						if(Arrays.equals(luckypick, lottodraw)){
							int prize = 30000000;
							JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + "!", "Result", JOptionPane.INFORMATION_MESSAGE);
							System.out.println("-------------------------------------");
							System.out.println("     You won $" + prize);
							System.out.println("-------------------------------------");
							balance += prize;
							displayMegalotto();
						}//end of if
							else{
								
							System.out.println("-------------------------------------");
							System.out.println("     You lost!");
							System.out.println("-------------------------------------");	
								JOptionPane.showMessageDialog(null, "Better Luck Next time!", "Result", JOptionPane.INFORMATION_MESSAGE);
								displayMegalotto();
							}
						
				}//end of else
			}//end of 4Digit Lotto method
		
			public void runMegalottoBet(){
				int playerbet[] = new int[6];
				int lottodraw[] = new int[6];
				System.out.println("-------------------------------------");
				System.out.println("The ticket price is $20");
				System.out.println("The Jackpot price is $30,000,000");
				System.out.println("-------------------------------------");
				JOptionPane.showMessageDialog(null, "Ticket price is $20", "Price", JOptionPane.INFORMATION_MESSAGE);
				int wager = 20;
				
				//if wager is greater than balance
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					displayMegalotto();
				}//end of if
				
				else{
					for(int i = 0; i < playerbet.length; i++){
						System.out.println("-------------------------------------");
						System.out.print("Please enter your digit no." + (i + 1) + " : ");
						playerbet[i] = sc.nextInt();
						System.out.println("-------------------------------------");
							if(playerbet[i] > 45 | playerbet[i] < 1){
								JOptionPane.showMessageDialog(null, "You can only select numbers 1 to 45! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
								runMegalottoBet();
							}
					}//end for
					//print the user bet
					balance -= wager;
					System.out.println("-------------------------------------");
					System.out.println("Your lotto ticket: " + Arrays.toString(playerbet));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "Lotto ticket : " + Arrays.toString(playerbet), "6/45 Mega Lotto", JOptionPane.INFORMATION_MESSAGE);

					//generate the numbers for the lotto draw
					JOptionPane.showMessageDialog(null, "The 6/45 Mega Lotto will start after you click OK", "Lotto Draw", JOptionPane.WARNING_MESSAGE);
					for(int y = 0; y < lottodraw.length; y++){
						lottodraw[y] = 1 + randomNumbers.nextInt(45);
					}
					System.out.println("-------------------------------------");
					System.out.println("The winning combination is : " + Arrays.toString(lottodraw));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "The winning combination is : " + Arrays.toString(lottodraw), "6/45 Mega Lotto", JOptionPane.INFORMATION_MESSAGE);
					
					//Finds out if the user won or lost
					if(Arrays.equals(playerbet, lottodraw)){
							int prize = 30000000;
							JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + "!", "Result", JOptionPane.INFORMATION_MESSAGE);
							System.out.println("-------------------------------------");
							System.out.println("     You won $" + prize);
							System.out.println("-------------------------------------");
							balance += prize;
							displayMegalotto();
						}//end of if
							else{
							
							System.out.println("-------------------------------------");
							System.out.println("     You lost!");
							System.out.println("-------------------------------------");	
								JOptionPane.showMessageDialog(null, "Better Luck Next time!", "Result", JOptionPane.INFORMATION_MESSAGE);
								displayMegalotto();
								
							}
		
				}//end of else

			}//end of runMegalottoBet()

			public void runGrandlottoLuckyPick(){
				int luckypick[] = new int[6];
				int lottodraw[] = new int[6];
				System.out.println("-------------------------------------");
				System.out.println("The ticket price is $25");
				System.out.println("The Jackpot price is $100,000,000");
				System.out.println("-------------------------------------");
				JOptionPane.showMessageDialog(null, "Ticket price is $25", "Price", JOptionPane.INFORMATION_MESSAGE);
				int wager = 25;
				//if wager is greater than balance
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					displayGrandlotto();
				}//end of if
				else {
					balance -= wager;
					JOptionPane.showMessageDialog(null, "Lucky Pick is generating numbers for you", "6/55 Gran Lotto!", JOptionPane.INFORMATION_MESSAGE);
					//Generate the numbers of luckypick
					luckypick[0] = 1 + randomNumbers.nextInt(55);
					luckypick[1] = 1 + randomNumbers.nextInt(55);
					luckypick[2] = 1 + randomNumbers.nextInt(55);
					luckypick[3] = 1 + randomNumbers.nextInt(55);
					luckypick[4] = 1 + randomNumbers.nextInt(55);
					luckypick[5] = 1 + randomNumbers.nextInt(55);
					System.out.println("-------------------------------------");
					System.out.println("Lucky pick Generated: " + Arrays.toString(luckypick));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "Lotto ticket : " + Arrays.toString(luckypick), "6/55 Grand Lotto!", JOptionPane.INFORMATION_MESSAGE);
					
					//generate the numbers for the lotto draw
					JOptionPane.showMessageDialog(null, "The 6/55 Grand Lotto draw will start after you click OK", "6/55 Grand Lotto!", JOptionPane.WARNING_MESSAGE);
					for(int y = 0; y < lottodraw.length; y++){
						lottodraw[y] = 1 + randomNumbers.nextInt(55);
					}
					System.out.println("-------------------------------------");
					System.out.println("The winning combination is : " + Arrays.toString(lottodraw));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "The winning combination is : " + Arrays.toString(lottodraw), "6/55 Grand Lotto", JOptionPane.INFORMATION_MESSAGE);
					
					//decides wether the player wins or losses
						if(Arrays.equals(luckypick, lottodraw)){
							int prize = 100000000;
							JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + "!", "Result", JOptionPane.INFORMATION_MESSAGE);
							System.out.println("-------------------------------------");
							System.out.println("     You won $" + prize);
							System.out.println("-------------------------------------");
							balance += prize;
							displayGrandlotto();
						}//end of if
							else{
								
							System.out.println("-------------------------------------");
							System.out.println("     You lost!");
							System.out.println("-------------------------------------");	
								JOptionPane.showMessageDialog(null, "Better Luck Next time!", "Result", JOptionPane.INFORMATION_MESSAGE);
								displayGrandlotto();
							}
						
				}//end of else
			}//end of 6/55 grand lotto
		
			public void runGrandlottoBet(){
				int playerbet[] = new int[6];
				int lottodraw[] = new int[6];
				System.out.println("-------------------------------------");
				System.out.println("The ticket price is $25");
				System.out.println("The Jackpot price is $100,000,000");
				System.out.println("-------------------------------------");
				JOptionPane.showMessageDialog(null, "Ticket price is $25", "Price", JOptionPane.INFORMATION_MESSAGE);
				int wager = 25;
				
				//if wager is greater than balance
				if(balance < wager){
					JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.WARNING_MESSAGE);
					displayMegalotto();
				}//end of if
				
				else{
					for(int i = 0; i < playerbet.length; i++){
						System.out.println("-------------------------------------");
						System.out.print("Please enter your digit no." + (i + 1) + " : ");
						playerbet[i] = sc.nextInt();
						System.out.println("-------------------------------------");
							if(playerbet[i] > 55 | playerbet[i] < 1){
								JOptionPane.showMessageDialog(null, "You can only select numbers 1 to 55! Please try again!", "Error", JOptionPane.WARNING_MESSAGE);
								runGrandlottoBet();
							}
					}//end for
					//print the user bet
					balance -= wager;
					System.out.println("-------------------------------------");
					System.out.println("Your lotto ticket: " + Arrays.toString(playerbet));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "Lotto ticket : " + Arrays.toString(playerbet), "6/55 Grand Lotto", JOptionPane.INFORMATION_MESSAGE);

					//generate the numbers for the lotto draw
					JOptionPane.showMessageDialog(null, "The 6/55 Grand Lotto will start after you click OK", "Lotto Draw", JOptionPane.WARNING_MESSAGE);
					for(int y = 0; y < lottodraw.length; y++){
						lottodraw[y] = 1 + randomNumbers.nextInt(55);
					}
					System.out.println("-------------------------------------");
					System.out.println("The winning combination is : " + Arrays.toString(lottodraw));
					System.out.println("-------------------------------------");
					JOptionPane.showMessageDialog(null, "The winning combination is : " + Arrays.toString(lottodraw), "6/55 Grand Lotto", JOptionPane.INFORMATION_MESSAGE);
					
					//Finds out if the user won or lost
					if(Arrays.equals(playerbet, lottodraw)){
							int prize = 100000000;
							JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + "!", "Result", JOptionPane.INFORMATION_MESSAGE);
							System.out.println("-------------------------------------");
							System.out.println("     You won $" + prize);
							System.out.println("-------------------------------------");
							balance += prize;
							displayGrandlotto();
						}//end of if
							else{
							
							System.out.println("-------------------------------------");
							System.out.println("     You lost!");
							System.out.println("-------------------------------------");	
								JOptionPane.showMessageDialog(null, "Better Luck Next time!", "Result", JOptionPane.INFORMATION_MESSAGE);
								displayGrandlotto();
								
							}
		
				}//end of else

			}//end of runGrandlottoBet()
			
			//BINGO METHODS!
			public void runBingoGrandlotto(){
				int playerbet[] = new int[6];
				int lottodraw[] = new int[6];
				int ticketPrice = 25;
				System.out.println("-------------------------------------");
				System.out.println("The ticket price is $25");
				System.out.println("The Jackpot price is $100,000,000");
				System.out.println("-------------------------------------");
				//Ask user how many tickets do you want to purchase
				System.out.print("How many tickets do you want to purchase? ");
				int ticketNo = sc.nextInt();
				int wager = (ticketNo * ticketPrice);
					
					//if the user has no balance left
					if(balance < wager){
						JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.ERROR_MESSAGE);
						System.out.println("-------------------------------------");
						System.out.println("You may can only purchase " + (balance / ticketPrice) + " tickets!");
						System.out.println("-------------------------------------");
						displayGrandlotto();
					}//end of if
					
					else{
						balance -= wager;
						JOptionPane.showMessageDialog(null, "The draw will start after you click OK", "INFO", JOptionPane.INFORMATION_MESSAGE);
						for(int i = 1; i <= ticketNo; i++){
							for(int y = 0; y < playerbet.length;y++ ){
								playerbet[y] = 1 + randomNumbers.nextInt(55);
								lottodraw[y] = 1 + randomNumbers.nextInt(55);
								
								
								}//end of for
								System.out.println("-------------------------------------");
								System.out.println(" Your ticket no." + i + " is " + Arrays.toString(playerbet));
								System.out.println("-------------------------------------");
								JOptionPane.showMessageDialog(null, "Your 6/55 Grand Lotto ticket no." + i +": " + Arrays.toString(playerbet), "Lotto Ticket", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("-------------------------------------");
								System.out.println(" Lotto draw no." + i + " is " + Arrays.toString(lottodraw));
								System.out.println("-------------------------------------");
								JOptionPane.showMessageDialog(null, "The 6/55 Grand Lotto draw no." + i +" Winning combination : " + Arrays.toString(lottodraw), "Lotto Ticket", JOptionPane.INFORMATION_MESSAGE);
								if(Arrays.equals(playerbet, lottodraw)){
								int prize = 100000000;
								JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + "!", "Result", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("-------------------------------------");
								System.out.println("     You won $" + prize);
								System.out.println("-------------------------------------");
								balance += prize;
								}
								else{
								JOptionPane.showMessageDialog(null, "Sorry you lose!", "Ticket no" + i, JOptionPane.ERROR_MESSAGE);
								}
													
					}//end of for
					}//end of else
				displayGrandlotto();
			}
			
			//MEga lotto
			public void runBingoMegalotto(){
				int playerbet[] = new int[6];
				int lottodraw[] = new int[6];
				int ticketPrice = 20;
				System.out.println("-------------------------------------");
				System.out.println("The ticket price is $20");
				System.out.println("The Jackpot price is $30,000,000");
				System.out.println("-------------------------------------");
				//Ask user how many tickets do you want to purchase
				System.out.print("How many tickets do you want to purchase? ");
				int ticketNo = sc.nextInt();
				int wager = (ticketNo * ticketPrice);
					
					//if the user has no balance left
					if(balance < wager){
						JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.ERROR_MESSAGE);
						System.out.println("-------------------------------------");
						System.out.println("You may can only purchase " + (balance / ticketPrice) + " tickets!");
						System.out.println("-------------------------------------");
						displayMegalotto();
					}//end of if
					
					else{
						balance -= wager;
						JOptionPane.showMessageDialog(null, "The draw will start after you click OK", "INFO", JOptionPane.INFORMATION_MESSAGE);
						for(int i = 1; i <= ticketNo; i++){
							for(int y = 0; y < playerbet.length;y++ ){
								playerbet[y] = 1 + randomNumbers.nextInt(55);
								lottodraw[y] = 1 + randomNumbers.nextInt(55);
								}//end of for
								System.out.println("-------------------------------------");
								System.out.println(" Your ticket no." + i + " is " + Arrays.toString(playerbet));
								System.out.println("-------------------------------------");
								JOptionPane.showMessageDialog(null, "Your 6/45 Mega Lotto ticket no." + i +": " + Arrays.toString(playerbet), "Lotto Ticket", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("-------------------------------------");
								System.out.println(" Lotto draw no." + i + " is " + Arrays.toString(lottodraw));
								System.out.println("-------------------------------------");
								JOptionPane.showMessageDialog(null, "The 6/45 Mega Lotto draw no." + i +" Winning combination : " + Arrays.toString(lottodraw), "Lotto Ticket", JOptionPane.INFORMATION_MESSAGE);
								if(Arrays.equals(playerbet, lottodraw)){
								int prize = 30000000;
								JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + "!", "Result", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("-------------------------------------");
								System.out.println("     You won $" + prize);
								System.out.println("-------------------------------------");
								balance += prize;
								}
								else{
								JOptionPane.showMessageDialog(null, "Sorry you lose!", "Ticket no" + i, JOptionPane.ERROR_MESSAGE);
								
								}
					
								
								
					}//end of for
					}//end of else
				displayMegalotto();
			}
			
			//FourDigitLotto
			public void runBingoFourlotto(){
				int playerbet[] = new int[4];
				int lottodraw[] = new int[4];
				System.out.println("-------------------------------------");
				System.out.println(" Prize is x 300 wager! ");
				System.out.println("-------------------------------------");
				System.out.print("How many games do you want to play? ");
				int gameNo = sc.nextInt();
				System.out.println("-------------------------------------");
				System.out.print("How much do you want to wager per game? ");
				int ticketPrice = sc.nextInt();
				System.out.println("-------------------------------------");
				
				int wager = (gameNo * ticketPrice);
				//conditional statement that checks if user has enough money
				if(balance < wager){
						JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.ERROR_MESSAGE);
						System.out.println("-------------------------------------");
						System.out.println("You may can only purchase " + (balance / ticketPrice) + " tickets!");
						System.out.println("-------------------------------------");
						displayFourlotto();
				}//end of if 
				
				else{
					balance -= wager;
					JOptionPane.showMessageDialog(null, "The game will start after you click OK", "INFO", JOptionPane.INFORMATION_MESSAGE);
					for(int i = 1; i <= gameNo; i++){
						for(int y = 0; y < playerbet.length; y++){
							playerbet[y] = 0 + randomNumbers.nextInt(9);
							lottodraw[y] = 0 + randomNumbers.nextInt(9);
						}
								System.out.println("-------------------------------------");
								System.out.println(" Your ticket no." + i + " is " + Arrays.toString(playerbet));
								System.out.println("-------------------------------------");
								JOptionPane.showMessageDialog(null, "Your 4Digit Lotto ticket no." + i +": " + Arrays.toString(playerbet), "Lotto Ticket", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("-------------------------------------");
								System.out.println(" Lotto draw no." + i + " is " + Arrays.toString(lottodraw));
								System.out.println("-------------------------------------");
								JOptionPane.showMessageDialog(null, "The 4Digit Lotto draw no." + i +" Winning combination : " + Arrays.toString(lottodraw), "Lotto Ticket", JOptionPane.INFORMATION_MESSAGE);
						if(Arrays.equals(playerbet, lottodraw)){
								int prize = ticketPrice * 400;
								JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + "!", "Result", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("-------------------------------------");
								System.out.println("     You won $" + prize);
								System.out.println("-------------------------------------");
								balance += prize;
						}
							else{
								JOptionPane.showMessageDialog(null, "Sorry you lose!", "Ticket no" + i, JOptionPane.ERROR_MESSAGE);
							}//end of else
					}//end of for
				}//end of first else
				displayFourlotto();
			}// end of runBingoFourlotto
			
			//suertres Bingo
			public void runBingoSuertreslotto(){
				int playerbet[] = new int[3];
				int lottodraw[] = new int[3];
				System.out.println("-------------------------------------");
				System.out.println(" Prize is x 300 wager! ");
				System.out.println("-------------------------------------");
				System.out.print("How many games do you want to play? ");
				int gameNo = sc.nextInt();
				System.out.println("-------------------------------------");
				System.out.print("How much do you want to wager per game? ");
				int ticketPrice = sc.nextInt();
				System.out.println("-------------------------------------");
				
				int wager = (gameNo * ticketPrice);
				//conditional statement that checks if user has enough money
				if(balance < wager){
						JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.ERROR_MESSAGE);
						System.out.println("-------------------------------------");
						System.out.println("You may can only purchase " + (balance / ticketPrice) + " tickets! at " + ticketPrice + " per ticket!" );
						System.out.println("-------------------------------------");
						displayTreslotto();
				}//end of if 
				
				else{
					balance -= wager;
					JOptionPane.showMessageDialog(null, "The game will start after you click OK", "INFO", JOptionPane.INFORMATION_MESSAGE);
					for(int i = 1; i <= gameNo; i++){
						for(int y = 0; y < playerbet.length; y++){
							playerbet[y] = 0 + randomNumbers.nextInt(9);
							lottodraw[y] = 0 + randomNumbers.nextInt(9);
						}
								System.out.println("-------------------------------------");
								System.out.println(" Your ticket no." + i + " is " + Arrays.toString(playerbet));
								System.out.println("-------------------------------------");
								JOptionPane.showMessageDialog(null, "Your Suertres Lotto ticket no." + i +": " + Arrays.toString(playerbet), "Lotto Ticket", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("-------------------------------------");
								System.out.println(" Lotto draw no." + i + " is " + Arrays.toString(lottodraw));
								System.out.println("-------------------------------------");
								JOptionPane.showMessageDialog(null, "The Suertres Lotto draw no." + i +" Winning combination : " + Arrays.toString(lottodraw), "Lotto Ticket", JOptionPane.INFORMATION_MESSAGE);
						if(Arrays.equals(playerbet, lottodraw)){
								int prize = ticketPrice * 300;
								JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + "!", "Result", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("-------------------------------------");
								System.out.println("     You won $" + prize);
								System.out.println("-------------------------------------");
								balance += prize;
						}
							else{
								JOptionPane.showMessageDialog(null, "Sorry you lose!", "Ticket no" + i, JOptionPane.ERROR_MESSAGE);
							}//end of else
					}//end of for
				}//end of first else
				displayTreslotto();
			}// end of SuertresBingo
		
			// ezTwoLotto Bingo
			public void runBingoEZlotto(){
				int playerbet[] = new int[2];
				int lottodraw[] = new int[2];
				System.out.println("-------------------------------------");
				System.out.println(" Prize is x 200 wager! ");
				System.out.println("-------------------------------------");
				System.out.print("How many games do you want to play? ");
				int gameNo = sc.nextInt();
				System.out.println("-------------------------------------");
				System.out.print("How much do you want to wager per game? ");
				int ticketPrice = sc.nextInt();
				System.out.println("-------------------------------------");
				
				int wager = (gameNo * ticketPrice);
				//conditional statement that checks if user has enough money
				if(balance < wager){
						JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.ERROR_MESSAGE);
						System.out.println("-------------------------------------");
						System.out.println("You may can only purchase " + (balance / ticketPrice) + " tickets! at " + ticketPrice + " per ticket!" );
						System.out.println("-------------------------------------");
						displayEzlotto();
				}//end of if 
				
				else{
					balance -= wager;
					JOptionPane.showMessageDialog(null, "The game will start after you click OK", "INFO", JOptionPane.INFORMATION_MESSAGE);
					for(int i = 1; i <= gameNo; i++){
						for(int y = 0; y < playerbet.length; y++){
							playerbet[y] = 0 + randomNumbers.nextInt(9);
							lottodraw[y] = 0 + randomNumbers.nextInt(9);
						}
								System.out.println("-------------------------------------");
								System.out.println("Game no. " + i);
								System.out.println(" Your ticket no." + i + " is " + Arrays.toString(playerbet));
								JOptionPane.showMessageDialog(null, "Your EZ2 Lotto ticket no." + i +": " + Arrays.toString(playerbet), "Lotto Ticket", JOptionPane.INFORMATION_MESSAGE);
								System.out.println(" Lotto draw no." + i + " is " + Arrays.toString(lottodraw));
								System.out.println("-------------------------------------");
								JOptionPane.showMessageDialog(null, "The EZ2 Lotto draw no." + i +" Winning combination : " + Arrays.toString(lottodraw), "Lotto Ticket", JOptionPane.INFORMATION_MESSAGE);
						if(Arrays.equals(playerbet, lottodraw)){
								int prize = ticketPrice * 200;
								JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize + "!", "Result", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("-------------------------------------");
								System.out.println("     You won $" + prize);
								System.out.println("-------------------------------------");
								balance += prize;
						}
							else{
								JOptionPane.showMessageDialog(null, "Sorry you lose!", "Ticket no" + i, JOptionPane.ERROR_MESSAGE);
							}//end of else
					}//end of for
				}//end of first else
				displayEzlotto();
			}// end of EZ2Lotto

			public void runBingoOneCoin(){
				String userCoin[] = {"Heads", "Tails"};
				String casinoCoin[] = {"Heads", "Tails"};
				System.out.println("-------------------------------------");
				System.out.println(" Prize is x2 wager! ");
				System.out.println("-------------------------------------");
				System.out.println("How many games do you want to play? ");
				System.out.println("-------------------------------------");
				System.out.print("Please enter no of games :");
				int gameNo = sc.nextInt();
				System.out.println("-------------------------------------");
				System.out.println("How much is your wager per game? ");
				System.out.println("-------------------------------------");
				System.out.print("Please enter wager per game ");
				int ticketPrice = sc.nextInt();
				int wager = (gameNo * ticketPrice);
				//Conditional statement that checks if user has enough funds
				if(balance < wager){
						JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.ERROR_MESSAGE);
						System.out.println("-------------------------------------");
						System.out.println("You may can only play " + (balance / ticketPrice) + " games! at $" + ticketPrice + " per game!" );
						System.out.println("-------------------------------------");
						displayOnecoin();
				}//end of if statement
				
				else{
					balance -= wager;
						JOptionPane.showMessageDialog(null, "The game will start after you click OK", "Info", JOptionPane.INFORMATION_MESSAGE);
						for(int i = 1; i <= gameNo; i++){
							int user = randomNumbers.nextInt(userCoin.length);
							int casino = randomNumbers.nextInt(casinoCoin.length);
							
							System.out.println("-------------------------------------");
							System.out.println("Game no. " + i);
							System.out.println("Your coin is " + userCoin[user]);
							System.out.println("Casino coin is " + casinoCoin[casino]);
							System.out.println("-------------------------------------");
							
							if(userCoin[user] == casinoCoin[casino]){
								int prize = (ticketPrice * 2);
								balance += prize;
								JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize, "Game no." + i, JOptionPane.INFORMATION_MESSAGE);
								System.out.println("-------------------------------------");
								System.out.println("You won " + prize + "!");
								System.out.println("Your balance is $" + balance);
								System.out.println("-------------------------------------");
							}//end of if statement
							else{
								JOptionPane.showMessageDialog(null, "Better luck next time!", "Game no." + i, JOptionPane.ERROR_MESSAGE);
								System.out.println("-------------------------------------");
								System.out.println("You lost!");
								System.out.println("-------------------------------------");
							}//end of else
						}//end of for
					
				}//end of else statement
				displayOnecoin();
			}//end of one coin method

			//bingo twocoin
			public void runBingoTwoCoin(){
				String userCoin[] = {"Heads", "Tails"};
				String casinoCoin1[] = {"Heads", "Tails"};
				String casinoCoin2[] = {"Heads", "Tails"};
				System.out.println("-------------------------------------");
				System.out.println(" Prize is x3 wager! ");
				System.out.println("-------------------------------------");
				System.out.println("How many games do you want to play? ");
				System.out.println("-------------------------------------");
				System.out.print("Please enter no of games :");
				int gameNo = sc.nextInt();
				System.out.println("-------------------------------------");
				System.out.println("How much is your wager per game? ");
				System.out.println("-------------------------------------");
				System.out.print("Please enter wager per game ");
				int ticketPrice = sc.nextInt();
				int wager = (gameNo * ticketPrice);
				//Conditional statement that checks if user has enough funds
				if(balance < wager){
						JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.ERROR_MESSAGE);
						System.out.println("-------------------------------------");
						System.out.println("You may can only play " + (balance / ticketPrice) + " games! at $" + ticketPrice + " per game!" );
						System.out.println("-------------------------------------");
						displayTwocoin();	
				}//end of if statement
				
				else{
					balance -= wager;
						JOptionPane.showMessageDialog(null, "The game will start after you click OK", "Info", JOptionPane.INFORMATION_MESSAGE);
						for(int i = 1; i <= gameNo; i++){
							int user = randomNumbers.nextInt(userCoin.length);
							int casino1 = randomNumbers.nextInt(userCoin.length);
							int casino2 = randomNumbers.nextInt(userCoin.length);
							
							System.out.println("-------------------------------------");
							System.out.println("Game no. " + i );
							System.out.println("Your coin no is " + userCoin[user]);
							System.out.println("Casino coin no.1 is " + casinoCoin1[casino1]);
							System.out.println("Casino coin no.2 is " + casinoCoin2[casino2]);
							System.out.println("-------------------------------------");
							
							if(userCoin[user] == casinoCoin1[casino1] && userCoin[user] == casinoCoin2[casino2]){
								int prize = (ticketPrice * 3);
								balance += prize;
								JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize, "Game no." + i, JOptionPane.INFORMATION_MESSAGE);
								System.out.println("-------------------------------------");
								System.out.println("You won " + prize + "!");
								System.out.println("Your balance is $" + balance);
								System.out.println("-------------------------------------");
							}//end of if statement
							else{
								JOptionPane.showMessageDialog(null, "Better luck next time!", "Game no." + i, JOptionPane.ERROR_MESSAGE);
								System.out.println("-------------------------------------");
								System.out.println("You lost!");
								System.out.println("-------------------------------------");
							}//end of else
						}//end of for
					
				}//end of else statement
				displayTwocoin();
			}//end of method
			
			// ThreeCoin
			public void runBingoThreeCoin(){
				String userCoin[] = {"Heads", "Tails"};
				String casinoCoin1[] = {"Heads", "Tails"};
				String casinoCoin2[] = {"Heads", "Tails"};
				String casinoCoin3[] = {"Heads", "Tails"};
				System.out.println("-------------------------------------");
				System.out.println(" Prize is x5 wager! ");
				System.out.println("-------------------------------------");
				System.out.println("How many games do you want to play? ");
				System.out.println("-------------------------------------");
				System.out.print("Please enter no of games :");
				int gameNo = sc.nextInt();
				System.out.println("-------------------------------------");
				System.out.println("How much is your wager per game? ");
				System.out.println("-------------------------------------");
				System.out.print("Please enter wager per game ");
				int ticketPrice = sc.nextInt();
				int wager = (gameNo * ticketPrice);
				//Conditional statement that checks if user has enough funds
				if(balance < wager){
						JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.ERROR_MESSAGE);
						System.out.println("-------------------------------------");
						System.out.println("You may can only play " + (balance / ticketPrice) + " games! at $" + ticketPrice + " per game!" );
						System.out.println("-------------------------------------");
						displayThreecoin();
				}//end of if statement
				
				else{
					balance -= wager;
						JOptionPane.showMessageDialog(null, "The game will start after you click OK", "Info", JOptionPane.INFORMATION_MESSAGE);
						for(int i = 1; i <= gameNo; i++){
							int user = randomNumbers.nextInt(userCoin.length);
							int casino1 = randomNumbers.nextInt(userCoin.length);
							int casino2 = randomNumbers.nextInt(userCoin.length);
							int casino3 = randomNumbers.nextInt(userCoin.length);
							
							System.out.println("-------------------------------------");
							System.out.println("Game no. " + i );
							System.out.println("Your coin is " + userCoin[user]);
							System.out.println("Casino coin no.1 is " + casinoCoin1[casino1]);
							System.out.println("Casino coin no.2 is " + casinoCoin2[casino2]);
							System.out.println("Casino coin no.3 is " + casinoCoin3[casino3]);
							System.out.println("-------------------------------------");
							
							if(userCoin[user] == casinoCoin1[casino1] && userCoin[user] == casinoCoin2[casino2] && casinoCoin1[casino1] == casinoCoin3[casino3]){
								int prize = (ticketPrice * 5);
								balance += prize;
								JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize, "Game no." + i, JOptionPane.INFORMATION_MESSAGE);
								System.out.println("-------------------------------------");
								System.out.println("You won " + prize + "!");
								System.out.println("Your balance is $" + balance);
								System.out.println("-------------------------------------");
							}//end of if statement
							else{
								JOptionPane.showMessageDialog(null, "Better luck next time!", "Game no." + i, JOptionPane.ERROR_MESSAGE);
								System.out.println("-------------------------------------");
								System.out.println("You lost!");
								System.out.println("-------------------------------------");
							}//end of else
						}//end of for
					
				}//end of else statement
				displayThreecoin();
			}//end of method

			public void runBingoOneDice(){
				int userDice[] = new int[6];
				int casinoDice[] = new int[6];
				
				//put value on the dices
				for(int i = 0; i < userDice.length; i++){
					userDice[i] = i + 1;  // i + 1 because user[0] is 1
					casinoDice[i] = i + 1;
				}//end of for
				
				System.out.println("-------------------------------------");
				System.out.println("How many games do you want to play? ");
				System.out.println("-------------------------------------");
				System.out.print("Please enter number of games: ");
				int gameNo = sc.nextInt();
				System.out.println("-------------------------------------");
				System.out.println("How much do you want to wage per game ?");
				System.out.println("-------------------------------------");
				System.out.print("Please enter wager price: $");
				int ticketPrice = sc.nextInt();
				System.out.println("-------------------------------------");
				int wager = gameNo * ticketPrice;
				//statement to check if user has enough money
				if(balance < wager){
						JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.ERROR_MESSAGE);
						System.out.println("-------------------------------------");
						System.out.println("You may can only play " + (balance / ticketPrice) + " games! at $" + ticketPrice + " per game!" );
						System.out.println("-------------------------------------");
						displayOnedice();
				}//end of if statement
				
				else{
					balance -= wager;
					JOptionPane.showMessageDialog(null, "The game will start after you click OK", "Info", JOptionPane.INFORMATION_MESSAGE);
						for(int count = 1; count <= gameNo; count++){
							int user = randomNumbers.nextInt(userDice.length);
							int casino = randomNumbers.nextInt(casinoDice.length);
							System.out.println("-------------------------------------");
							System.out.println("Game no. " + count);
							System.out.println("Player's roll is " + userDice[user]);
							System.out.println("Casino's roll is " + casinoDice[casino]);
							
							//checks if who is the winner
							if(userDice[user] == casinoDice[casino]){
								JOptionPane.showMessageDialog(null, "Game is tie!", "Result", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("Player's roll and Casino's roll are equal");
								System.out.println("We roll again ");
								System.out.println("-------------------------------------");
								gameNo += 1;
							}//end of if
							
							else if(userDice[user] > casinoDice[casino]){
								int prize = (ticketPrice * 2);
								balance += prize;
								JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize, "Game no. " + count, JOptionPane.INFORMATION_MESSAGE);
								System.out.println("Player's roll is higher than the Casino's roll");
								System.out.println("You won $" + prize + "!");
								System.out.println("Balance is $" + balance); 
								System.out.println("-------------------------------------");
							}//end of else if
							else{
								JOptionPane.showMessageDialog(null, "Better luck next time!", "Game no." + count, JOptionPane.ERROR_MESSAGE);
								System.out.println("Casino's roll is higher than Player's roll!");
								System.out.println("You lost!");
								System.out.println("-------------------------------------");
							}//
						}// end of for loop
				}// end of else
				displayOnedice();	
			}//end of runBingoOneDice

			//two dice
			public void runBingoTwoDice(){
				int userDice1[] = new int[6];
				int userDice2[] = new int[6];
				int casinoDice1[] = new int[6];
				int casinoDice2[] = new int[6];
				
				//put value on the dices
				for(int i = 0; i < userDice1.length; i++){
					userDice1[i] = i + 1;  // i + 1 because user[0] is 
					userDice2[i] = i + 1;
					casinoDice1[i] = i + 1;
					casinoDice2[i] = i + 1;
				}//end of for
				
				System.out.println("-------------------------------------");
				System.out.println("How many games do you want to play? ");
				System.out.println("-------------------------------------");
				System.out.print("Please enter number of games: ");
				int gameNo = sc.nextInt();
				System.out.println("-------------------------------------");
				System.out.println("How much do you want to wage per game ?");
				System.out.println("-------------------------------------");
				System.out.print("Please enter wager price: $");
				int ticketPrice = sc.nextInt();
				System.out.println("-------------------------------------");
				int wager = gameNo * ticketPrice;
				//statement to check if user has enough money
				if(balance < wager){
						JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.ERROR_MESSAGE);
						System.out.println("-------------------------------------");
						System.out.println("You may can only play " + (balance / ticketPrice) + " games! at $" + ticketPrice + " per game!" );
						System.out.println("-------------------------------------");
						displayTwodice();
				}//end of if statement
				
				else{
					balance -= wager;
					JOptionPane.showMessageDialog(null, "The game will start after you click OK", "Info", JOptionPane.INFORMATION_MESSAGE);
						for(int count = 1; count <= gameNo; count++){
							int user1 = randomNumbers.nextInt(userDice1.length);
							int user2 = randomNumbers.nextInt(userDice1.length);
							int casino1 = randomNumbers.nextInt(casinoDice1.length);
							int casino2 = randomNumbers.nextInt(casinoDice1.length);
							System.out.println("-------------------------------------");
							System.out.println("Game no. " + count);
							System.out.println("Player's first roll is " + userDice1[user1]);
							System.out.println("Player's second roll is " + userDice2[user2]);
							System.out.println("-------------------------------------");
							System.out.println("Casino's first roll is " + casinoDice1[casino1]);
							System.out.println("Casino's second roll is " + casinoDice2[casino2]);
							System.out.println("-------------------------------------");
							int userTotal = (userDice1[user1] + userDice2[user2]);
							int casinoTotal = (casinoDice1[casino1] + casinoDice2[casino2]);
							System.out.println("Player's total  roll is " + userTotal);
							System.out.println("Casino's total roll is " + casinoTotal);
							System.out.println("-------------------------------------");
							//checks if who is the winner
							if(userTotal == casinoTotal){
								JOptionPane.showMessageDialog(null, "Game is tie!", "Result", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("Player's roll and Casino's roll are equal");
								System.out.println("We roll again ");
								System.out.println("-------------------------------------");
								gameNo += 1;
							}//end of if
							
							else if(userTotal > casinoTotal){
								int prize = (ticketPrice * 2);
								balance += prize;
								JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize, "Game no. " + count, JOptionPane.INFORMATION_MESSAGE);
								System.out.println("Player's roll is higher than the Casino's roll");
								System.out.println("You won $" + prize + "!");
								System.out.println("Balance is $" + balance); 
								System.out.println("-------------------------------------");
							}//end of else if
							else{
								JOptionPane.showMessageDialog(null, "Better luck next time!", "Game no." + count, JOptionPane.ERROR_MESSAGE);
								System.out.println("Casino's roll is higher than Player's roll!");
								System.out.println("You lost!");
								System.out.println("-------------------------------------");
							}//
						}// end of for loop
				}// end of else
				displayTwodice();	
			}//end of runBingoOneDice
			
			// Three dice
			public void runBingoThreeDice(){
				int userDice1[] = new int[6];
				int userDice2[] = new int[6];
				int userDice3[] = new int[6];
				int casinoDice1[] = new int[6];
				int casinoDice2[] = new int[6];
				int casinoDice3[] = new int[6];
				
				//put value on the dices
				for(int i = 0; i < userDice1.length; i++){
					userDice1[i] = i + 1;  // i + 1 because user[0] is 
					userDice2[i] = i + 1;
					userDice3[i] = i + 1;
					casinoDice1[i] = i + 1;
					casinoDice2[i] = i + 1;
					casinoDice3[i] = i + 1;
				}//end of for
				
				System.out.println("-------------------------------------");
				System.out.println("How many games do you want to play? ");
				System.out.println("-------------------------------------");
				System.out.print("Please enter number of games: ");
				int gameNo = sc.nextInt();
				System.out.println("-------------------------------------");
				System.out.println("How much do you want to wage per game ?");
				System.out.println("-------------------------------------");
				System.out.print("Please enter wager price: $");
				int ticketPrice = sc.nextInt();
				System.out.println("-------------------------------------");
				int wager = gameNo * ticketPrice;
				//statement to check if user has enough money
				if(balance < wager){
						JOptionPane.showMessageDialog(null, "Insufficient funds!", "Error", JOptionPane.ERROR_MESSAGE);
						System.out.println("-------------------------------------");
						System.out.println("You may can only play " + (balance / ticketPrice) + " games! at $" + ticketPrice + " per game!" );
						System.out.println("-------------------------------------");
						displayThreedice();
				}//end of if statement
				
				else{
					balance -= wager;
					JOptionPane.showMessageDialog(null, "The game will start after you click OK", "Info", JOptionPane.INFORMATION_MESSAGE);
						for(int count = 1; count <= gameNo; count++){
							int user1 = randomNumbers.nextInt(userDice1.length);
							int user2 = randomNumbers.nextInt(userDice1.length);
							int user3 = randomNumbers.nextInt(userDice1.length);
							int casino1 = randomNumbers.nextInt(casinoDice1.length);
							int casino2 = randomNumbers.nextInt(casinoDice1.length);
							int casino3 = randomNumbers.nextInt(casinoDice1.length);
							System.out.println("-------------------------------------");
							System.out.println("Game no. " + count);
							System.out.println("Player's first roll is " + userDice1[user1]);
							System.out.println("Player's second roll is " + userDice2[user2]);
							System.out.println("Player's third roll is " + userDice3[user3]);
							System.out.println("-------------------------------------");
							System.out.println("Casino's first roll is " + casinoDice1[casino1]);
							System.out.println("Casino's second roll is " + casinoDice2[casino2]);
							System.out.println("Casino's third roll is " + casinoDice2[casino3]);
							System.out.println("-------------------------------------");
							int userTotal = (userDice1[user1] + userDice2[user2] + userDice3[user3]);
							int casinoTotal = (casinoDice1[casino1] + casinoDice2[casino2] + casinoDice3[casino3]);
							System.out.println("Player's total  roll is " + userTotal);
							System.out.println("Casino's total roll is " + casinoTotal);
							System.out.println("-------------------------------------");
							//checks if who is the winner
							if(userTotal == casinoTotal){
								JOptionPane.showMessageDialog(null, "Game is tie!", "Result", JOptionPane.INFORMATION_MESSAGE);
								System.out.println("Player's roll and Casino's roll are equal");
								System.out.println("We roll again ");
								System.out.println("-------------------------------------");
								gameNo += 1;
							}//end of if
							
							else if(userTotal > casinoTotal){
								int prize = (ticketPrice * 2);
								balance += prize;
								JOptionPane.showMessageDialog(null, "Congratulations you won $" + prize, "Game no. " + count, JOptionPane.INFORMATION_MESSAGE);
								System.out.println("Player's roll is higher than the Casino's roll");
								System.out.println("You won $" + prize + "!");
								System.out.println("Balance is $" + balance); 
								System.out.println("-------------------------------------");
							}//end of else if
							else{
								JOptionPane.showMessageDialog(null, "Better luck next time!", "Game no." + count, JOptionPane.ERROR_MESSAGE);
								System.out.println("Casino's roll is higher than Player's roll!");
								System.out.println("You lost!");
								System.out.println("-------------------------------------");
							}//
						}// end of for loop
				}// end of else
				displayThreedice();	
			}//end of runBingoOneDice
}
            			

